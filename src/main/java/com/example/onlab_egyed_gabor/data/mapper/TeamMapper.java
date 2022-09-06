package com.example.onlab_egyed_gabor.data.mapper;

import com.example.onlab_egyed_gabor.controller.dto.TeamDTO;
import com.example.onlab_egyed_gabor.data.entities.TeamEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeamMapper {

    TeamDTO teamEntityToTeamDTO(TeamEntity teamEntity);

    TeamEntity teamDTOToTeamEntity(TeamDTO teamDTO);

    List<TeamEntity> teamDTOListToTeamEntityList(List<TeamDTO> teamDTOS);

    List<TeamDTO> teamEntityListToTeamDTOList(List<TeamEntity> teamEntities);
}
