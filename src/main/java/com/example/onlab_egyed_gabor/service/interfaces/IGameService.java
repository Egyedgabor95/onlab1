package com.example.onlab_egyed_gabor.service.interfaces;

import com.example.onlab_egyed_gabor.controller.dto.GameDTO;
import com.example.onlab_egyed_gabor.data.entities.GameEntity;

import java.util.List;

public interface IGameService {

    void create(GameDTO gameDTO);

    List<GameDTO> read();

    void update(Long targetId, GameDTO source);

    void delete(Long id);

    GameDTO findById(Long id);
}
