package com.example.onlab_egyed_gabor.data.mapper;

import com.example.onlab_egyed_gabor.controller.dto.RefereeDTO;
import com.example.onlab_egyed_gabor.data.entities.RefereeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface RefereeMapper {

    RefereeDTO refereeEntityToRefereeDTO(RefereeEntity refereeEntity);

    RefereeEntity refereeDTOToRefereeEntity(RefereeDTO refereeDTO);

    List<RefereeDTO> refereeEntityListToRefereeDTOList(List<RefereeEntity> refereeEntities);

    List<RefereeEntity> refereeDTOListToRefereeEntityList(List<RefereeDTO> refereeDTOS);

    @Mapping(target = "id", ignore = true)
    RefereeEntity update(@MappingTarget RefereeEntity refereeEntity, RefereeDTO refereeDTO);
}
