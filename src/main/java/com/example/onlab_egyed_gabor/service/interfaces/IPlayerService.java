package com.example.onlab_egyed_gabor.service.interfaces;

import com.example.onlab_egyed_gabor.controller.dto.PlayerDTO;
import com.example.onlab_egyed_gabor.data.entities.PlayerEntity;

import java.util.List;

public interface IPlayerService {

    void create(PlayerDTO playerDTO);

    List<PlayerDTO> read();

    void update(int targetId, PlayerDTO source);

    void delete(int id);

    PlayerDTO findById(int id);
}
