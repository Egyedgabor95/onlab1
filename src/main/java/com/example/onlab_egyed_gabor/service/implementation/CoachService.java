package com.example.onlab_egyed_gabor.service.implementation;

import com.example.onlab_egyed_gabor.controller.dto.CoachDTO;
import com.example.onlab_egyed_gabor.data.entities.CoachEntity;
import com.example.onlab_egyed_gabor.data.mapper.CoachMapper;
import com.example.onlab_egyed_gabor.data.repository.CoachRepository;
import com.example.onlab_egyed_gabor.service.interfaces.ICoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class CoachService implements ICoachService {

    @Autowired
    private CoachRepository coachRepository;
    @Autowired
    private CoachMapper coachMapper;

    @Override
    public CoachEntity create(CoachDTO coachDTO) {
        return coachRepository.save(coachMapper.coachDTOToCoachEntity(coachDTO));
    }

    @Override
    public List<CoachDTO> read() {
        return coachMapper.coachEntityListToCoachDTOList(coachRepository.findAll());
    }

    @Override
    public void update(Long targetId, CoachDTO source) {
        coachMapper.update(findEntityById(targetId), source);
    }

    @Override
    public void delete(Long id) {
        coachRepository.delete(findEntityById(id));
    }

    @Override
    public CoachDTO findById(Long id) {
        return coachMapper.coachEntityToCoachDTO(coachRepository.findById(id).orElseThrow(() -> new RuntimeException("Cannot find Coach with this id")));
    }

    private CoachEntity findEntityById(Long id) {
        return coachRepository.findById(id).orElseThrow(() -> new RuntimeException("Cannot find Coach with this id"));
    }
}
