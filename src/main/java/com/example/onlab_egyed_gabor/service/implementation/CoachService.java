package com.example.onlab_egyed_gabor.service.implementation;

import com.example.onlab_egyed_gabor.controller.dto.CoachDTO;
import com.example.onlab_egyed_gabor.data.entities.CoachEntity;
import com.example.onlab_egyed_gabor.data.mapper.CoachMapper;
import com.example.onlab_egyed_gabor.data.repository.CoachRepository;
import com.example.onlab_egyed_gabor.service.interfaces.ICoachService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Transactional
@Service
public class CoachService implements ICoachService {

    @Autowired
    private CoachRepository coachRepository;
    @Autowired
    private CoachMapper coachMapper;

    @Override
    public CoachEntity create(CoachDTO coachDTO) {
        log.debug("CoachService : create = {}", coachDTO);
        return coachRepository.save(coachMapper.coachDTOToCoachEntity(coachDTO));
    }

    @Override
    public List<CoachDTO> read() {
        log.debug("CoachService : read");
        return coachMapper.coachEntityListToCoachDTOList(coachRepository.findAll());
    }

    @Override
    public void update(Long targetId, CoachDTO source) {
        log.debug("CoachService : update, targetId = {}, source = {}", targetId, source);
        coachMapper.update(findEntityById(targetId), source);
    }

    @Override
    public void delete(Long id) {
        log.debug("CoachService : delete, id = {}", id);
        coachRepository.delete(findEntityById(id));
    }

    @Override
    public CoachDTO findById(Long id) {
        log.debug("CoachService : findById, id = {}", id);
        return coachMapper.coachEntityToCoachDTO(coachRepository.findById(id).orElseThrow(() -> new RuntimeException("Cannot find Coach with this id")));
    }

    private CoachEntity findEntityById(Long id) {
        log.debug("CoachService : findEntityById, id = {}", id);
        return coachRepository.findById(id).orElseThrow(() -> new RuntimeException("Cannot find Coach with this id"));
    }
}
