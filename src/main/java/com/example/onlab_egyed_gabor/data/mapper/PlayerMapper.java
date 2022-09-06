package com.example.onlab_egyed_gabor.data.mapper;

import com.example.onlab_egyed_gabor.controller.dto.PlayerDTO;
import com.example.onlab_egyed_gabor.data.entities.PlayerEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlayerMapper {

    PlayerEntity playerDTOToPlayerEntity(PlayerDTO playerDTO);

    PlayerDTO playerEntityToPlayerDTO(PlayerEntity playerEntity);

    List<PlayerEntity> playerDTOListToPlayerEntityList(List<PlayerDTO> playerDTO);

    List<PlayerDTO> playerEntityListToPlayerDTOList(List<PlayerEntity> playerEntities);
}
