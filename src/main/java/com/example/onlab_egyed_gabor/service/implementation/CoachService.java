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

@Service
public class CoachService implements ICoachService {

    @Autowired
    private CoachRepository coachRepository;
    @Autowired
    private CoachMapper coachMapper;
    @Override
    public void create(CoachDTO coachDTO) {
        coachRepository.save(coachMapper.coachDTOToCoachEntity(coachDTO));
    }

    @Override
    public List<CoachEntity> read() {
        return coachRepository.findAll();
    }

    @Transactional
    @Override
    public void update(int targetId, CoachDTO source) {
        coachMapper.update(findById(targetId), source);
    }

    @Override
    public void delete(int id) {
        coachRepository.delete(findById(id));
    }

    @Override
    public CoachEntity findById(int id) {
        return coachRepository.findById(id).orElseThrow(()-> new RuntimeException("Cannot find Coach with this id"));
    }
}
