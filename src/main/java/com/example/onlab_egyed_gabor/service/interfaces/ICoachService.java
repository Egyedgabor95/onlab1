package com.example.onlab_egyed_gabor.service.interfaces;

import com.example.onlab_egyed_gabor.controller.dto.CoachDTO;
import com.example.onlab_egyed_gabor.data.entities.CoachEntity;

import java.util.List;

public interface ICoachService {

    void create(CoachDTO coachDTO);

    List<CoachDTO> read();

    void update(int targetId, CoachDTO source);

    void delete(int id);

    CoachDTO findById(int id);
}
