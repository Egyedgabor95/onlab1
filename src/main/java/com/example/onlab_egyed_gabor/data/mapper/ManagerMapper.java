package com.example.onlab_egyed_gabor.data.mapper;

import com.example.onlab_egyed_gabor.controller.dto.ManagerDTO;
import com.example.onlab_egyed_gabor.data.entities.ManagerEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ManagerMapper {

    ManagerEntity managerDTOToManagerEntity(ManagerDTO managerDTO);

    ManagerDTO managerEntityToManagerDTO(ManagerEntity managerEntity);

    List<ManagerEntity> managerDTOListToManagerEntityList(List<ManagerDTO> managerDTOS);

    List<ManagerDTO> managerEntityListToManagerDTOList(List<ManagerEntity> managerEntities);
}
