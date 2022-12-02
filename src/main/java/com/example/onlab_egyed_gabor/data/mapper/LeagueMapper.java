package com.example.onlab_egyed_gabor.data.mapper;

import com.example.onlab_egyed_gabor.controller.dto.LeagueDTO;
import com.example.onlab_egyed_gabor.data.entities.LeagueEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface LeagueMapper {
    @Mapping(target = "id", ignore = true)
    LeagueDTO leagueEntityToLeagueDTO(LeagueEntity leagueEntity);

    LeagueEntity leagueDTOToLeagueEntity(LeagueDTO leagueDTO);

    List<LeagueEntity> leagueDTOListToLeagueEntityList(List<LeagueDTO> leagueDTOS);

    List<LeagueDTO> leagueEntityListToLeagueDTOList(List<LeagueEntity> leagueEntities);
    @Mapping(target = "id", ignore = true)
    LeagueEntity update(@MappingTarget LeagueEntity leagueEntity, LeagueDTO leagueDTO);
}
