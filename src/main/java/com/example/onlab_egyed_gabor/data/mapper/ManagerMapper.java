package com.example.onlab_egyed_gabor.data.mapper;

import com.example.onlab_egyed_gabor.controller.dto.ManagerDTO;
import com.example.onlab_egyed_gabor.data.entities.ManagerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface ManagerMapper {
    @Mapping(target = "id", ignore = true)
    ManagerEntity managerDTOToManagerEntity(ManagerDTO managerDTO);

    ManagerDTO managerEntityToManagerDTO(ManagerEntity managerEntity);

    List<ManagerEntity> managerDTOListToManagerEntityList(List<ManagerDTO> managerDTOS);

    List<ManagerDTO> managerEntityListToManagerDTOList(List<ManagerEntity> managerEntities);
    @Mapping(target = "id", ignore = true)
    ManagerEntity update(@MappingTarget ManagerEntity managerEntity, ManagerDTO managerDTO);
}
