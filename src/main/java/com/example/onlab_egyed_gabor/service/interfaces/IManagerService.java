package com.example.onlab_egyed_gabor.service.interfaces;

import com.example.onlab_egyed_gabor.controller.dto.ManagerDTO;

import java.util.List;

public interface IManagerService {

    void create(ManagerDTO managerDTO);

    List<ManagerDTO> read();

    void update(Long targetId, ManagerDTO source);

    void delete(Long id);

    ManagerDTO findById(Long id);
}
