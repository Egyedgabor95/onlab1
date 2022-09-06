package com.example.onlab_egyed_gabor.data.mapper;

import com.example.onlab_egyed_gabor.controller.dto.CoachDTO;
import com.example.onlab_egyed_gabor.data.entities.CoachEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CoachMapper {

    CoachEntity coachDTOToCoachEntity (CoachDTO coachDTO);
    CoachDTO coachEntityToCoachDTO (CoachEntity coachEntity);
    List<CoachEntity> coachDTOListToCoachEntityList (List<CoachDTO> coachDTOs);
    List<CoachDTO> coachEntityListToCoachDTOList (List<CoachEntity> coachEntities);
}
