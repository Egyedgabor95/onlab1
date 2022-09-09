package com.example.onlab_egyed_gabor.data.mapper;

import com.example.onlab_egyed_gabor.controller.dto.GameDTO;
import com.example.onlab_egyed_gabor.data.entities.GameEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface GameMapper {

    GameEntity gameDTOToGameEntity(GameDTO gameDTO);

    GameDTO gameEntityToGameDTO(GameEntity gameEntity);

    List<GameEntity> gameDTOListToGameEntityList(List<GameDTO> gameDTOS);

    List<GameDTO> gameEntityListToGameDTOList(List<GameEntity> gameEntities);

    @Mapping(target = "id", ignore = true)
    GameEntity update(@MappingTarget GameEntity gameEntity, GameDTO gameDTO);
}
