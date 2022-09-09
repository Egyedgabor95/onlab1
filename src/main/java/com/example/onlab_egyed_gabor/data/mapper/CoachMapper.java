package com.example.onlab_egyed_gabor.data.mapper;

import com.example.onlab_egyed_gabor.controller.dto.CoachDTO;
import com.example.onlab_egyed_gabor.data.entities.CoachEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface CoachMapper {

    CoachEntity coachDTOToCoachEntity(CoachDTO coachDTO);

    CoachDTO coachEntityToCoachDTO(CoachEntity coachEntity);

    List<CoachEntity> coachDTOListToCoachEntityList(List<CoachDTO> coachDTOs);

    List<CoachDTO> coachEntityListToCoachDTOList(List<CoachEntity> coachEntities);

    @Mapping(target = "id", ignore = true)
    CoachEntity update(@MappingTarget CoachEntity coachEntity, CoachDTO coachDTO);
}
