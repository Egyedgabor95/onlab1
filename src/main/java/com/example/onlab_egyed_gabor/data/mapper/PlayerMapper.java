package com.example.onlab_egyed_gabor.data.mapper;

import com.example.onlab_egyed_gabor.controller.dto.PlayerDTO;
import com.example.onlab_egyed_gabor.data.entities.PlayerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface PlayerMapper {

    PlayerEntity playerDTOToPlayerEntity(PlayerDTO playerDTO);

    PlayerDTO playerEntityToPlayerDTO(PlayerEntity playerEntity);

    List<PlayerEntity> playerDTOListToPlayerEntityList(List<PlayerDTO> playerDTO);

    List<PlayerDTO> playerEntityListToPlayerDTOList(List<PlayerEntity> playerEntities);

    @Mapping(target = "id", ignore = true)
    PlayerEntity update(@MappingTarget PlayerEntity playerEntity, PlayerDTO playerDTO);
}
