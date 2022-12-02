package com.example.onlab_egyed_gabor.service.interfaces;

import com.example.onlab_egyed_gabor.controller.dto.PlayerDTO;
import com.example.onlab_egyed_gabor.data.entities.PlayerEntity;

import java.util.List;

public interface IPlayerService {

    PlayerEntity create(PlayerDTO playerDTO);

    List<PlayerDTO> read();

    void update(Long targetId, PlayerDTO source);

    void delete(Long id);

    PlayerDTO findById(Long id);
}
