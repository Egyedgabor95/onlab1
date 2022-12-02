package com.example.onlab_egyed_gabor.service.interfaces;

import com.example.onlab_egyed_gabor.controller.dto.PlayerDTO;

import java.util.List;

public interface IPlayerService {

    void create(PlayerDTO playerDTO);

    List<PlayerDTO> read();

    void update(Long targetId, PlayerDTO source);

    void delete(Long id);

    PlayerDTO findById(Long id);
}
