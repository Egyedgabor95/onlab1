package com.example.onlab_egyed_gabor.data.mapper;

import com.example.onlab_egyed_gabor.controller.dto.CoachDTO;
import com.example.onlab_egyed_gabor.controller.dto.TeamDTO;
import com.example.onlab_egyed_gabor.data.entities.CoachEntity;
import com.example.onlab_egyed_gabor.data.entities.TeamEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface TeamMapper {

    TeamDTO teamEntityToTeamDTO(TeamEntity teamEntity);

    TeamEntity teamDTOToTeamEntity(TeamDTO teamDTO);

    List<TeamEntity> teamDTOListToTeamEntityList(List<TeamDTO> teamDTOS);

    List<TeamDTO> teamEntityListToTeamDTOList(List<TeamEntity> teamEntities);

    @Mapping(target = "id", ignore = true)
    TeamEntity update(@MappingTarget TeamEntity teamEntity, TeamDTO teamDTO);
}
