package com.example.onlab_egyed_gabor.service.interfaces;

import com.example.onlab_egyed_gabor.controller.dto.RefereeDTO;
import com.example.onlab_egyed_gabor.data.entities.RefereeEntity;

import java.util.List;

public interface IRefereeService {

    void create(RefereeDTO refereeDTO);

    List<RefereeDTO> read();

    void update(int targetId, RefereeDTO source);

    void delete(int id);

    RefereeDTO findById(int id);
}
