package com.example.onlab_egyed_gabor.service.interfaces;

import com.example.onlab_egyed_gabor.controller.dto.CoachDTO;
import com.example.onlab_egyed_gabor.data.entities.CoachEntity;

import java.util.List;

public interface ICoachService {

    CoachEntity create(CoachDTO coachDTO);

    List<CoachDTO> read();

    void update(Long targetId, CoachDTO source);

    void delete(Long id);

    CoachDTO findById(Long id);
}
