package com.example.onlab_egyed_gabor.service.implementation;

import com.example.onlab_egyed_gabor.controller.dto.RefereeDTO;
import com.example.onlab_egyed_gabor.data.entities.RefereeEntity;
import com.example.onlab_egyed_gabor.data.mapper.RefereeMapper;
import com.example.onlab_egyed_gabor.data.repository.RefereeRepository;
import com.example.onlab_egyed_gabor.service.interfaces.IRefereeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
public class RefereeService implements IRefereeService {

    @Autowired
    private RefereeRepository refereeRepository;

    @Autowired
    private RefereeMapper refereeMapper;

    @Override
    public RefereeEntity create(RefereeDTO refereeDTO) {
        log.debug("RefereeService : create, RefereeDTO = {}", refereeDTO);
        return refereeRepository.save(refereeMapper.refereeDTOToRefereeEntity(refereeDTO));
    }

    @Override
    public List<RefereeDTO> read() {
        log.debug("RefereeService : read");
        return refereeMapper.refereeEntityListToRefereeDTOList(refereeRepository.findAll());
    }

    @Override
    public void update(Long targetId, RefereeDTO source) {
        log.debug("RefereeService : update, targetID = {}, source = {}", targetId, source);
        refereeMapper.update(findEntityById(targetId), source);
    }

    @Override
    public void delete(Long id) {
        log.debug("RefereeService : delete, id = {}", id);
        refereeRepository.delete(findEntityById(id));
    }

    @Override
    public RefereeDTO findById(Long id) {
        log.debug("RefereeService : delete, findById = {}", id);
        return refereeMapper.refereeEntityToRefereeDTO(refereeRepository.findById(id).orElseThrow(() -> new RuntimeException("Cannot find Referee with this id")));
    }

    private RefereeEntity findEntityById(Long id) {
        log.debug("RefereeService : findEntityById, id = {}", id);
        return refereeRepository.findById(id).orElseThrow(() -> new RuntimeException("Cannot find Referee with this id"));
    }
}
