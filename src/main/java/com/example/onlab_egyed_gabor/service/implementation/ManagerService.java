package com.example.onlab_egyed_gabor.service.implementation;

import com.example.onlab_egyed_gabor.controller.dto.ManagerDTO;
import com.example.onlab_egyed_gabor.data.entities.ManagerEntity;
import com.example.onlab_egyed_gabor.data.mapper.ManagerMapper;
import com.example.onlab_egyed_gabor.data.repository.ManagerRepository;
import com.example.onlab_egyed_gabor.service.interfaces.IManagerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
public class ManagerService implements IManagerService {

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private ManagerMapper managerMapper;

    @Override
    public ManagerEntity create(ManagerDTO managerDTO) {
        log.debug("ManagerService : create, ManagerDTO = {}", managerDTO);
        return managerRepository.save(managerMapper.managerDTOToManagerEntity(managerDTO));
    }

    @Override
    public List<ManagerDTO> read() {
        log.debug("ManagerService : read");
        return managerMapper.managerEntityListToManagerDTOList(managerRepository.findAll());
    }

    @Override
    public void update(Long targetId, ManagerDTO source) {
        log.debug("ManagerService : update, targetID = {}, source = {}", targetId, source);
        managerMapper.update(findEntityById(targetId), source);
    }

    @Override
    public void delete(Long id) {
        log.debug("ManagerService : delete, id = {}", id);
        managerRepository.delete(findEntityById(id));
    }

    @Override
    public ManagerDTO findById(Long id) {
        log.debug("ManagerService : delete, findById = {}", id);
        return managerMapper.managerEntityToManagerDTO(managerRepository.findById(id).orElseThrow(() -> new RuntimeException("Cannot find Manager with this id")));
    }

    private ManagerEntity findEntityById(Long id) {
        log.debug("ManagerService : findEntityById, id = {}", id);
        return managerRepository.findById(id).orElseThrow(() -> new RuntimeException("Cannot find Manager with this id"));
    }
}
