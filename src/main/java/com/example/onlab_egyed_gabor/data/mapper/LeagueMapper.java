package com.example.onlab_egyed_gabor.data.mapper;

import com.example.onlab_egyed_gabor.controller.dto.LeagueDTO;
import com.example.onlab_egyed_gabor.data.entities.LeagueEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LeagueMapper {

    LeagueDTO leagueEntityToLeagueDTO(LeagueEntity leagueEntity);

    LeagueEntity leagueDTOToLeagueEntity(LeagueDTO leagueDTO);

    List<LeagueEntity> leagueDTOListToLeagueEntityList(List<LeagueDTO> leagueDTOS);

    List<LeagueDTO> leagueEntityListToLeagueDTOList(List<LeagueEntity> leagueEntities);
}
