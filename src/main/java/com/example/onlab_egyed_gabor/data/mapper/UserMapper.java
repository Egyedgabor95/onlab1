package com.example.onlab_egyed_gabor.data.mapper;

import com.example.onlab_egyed_gabor.controller.dto.UserDTO;
import com.example.onlab_egyed_gabor.data.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO userEntityToUserDTO(UserEntity UserEntity);

    UserEntity userDTOToUserEntity(UserDTO UserDTO);

    List<UserEntity> userDTOListToUserEntityList(List<UserDTO> UserDTOS);

    List<UserDTO> userEntityListToUserDTOList(List<UserEntity> UserEntities);
    @Mapping(target = "id", ignore = true)
    UserEntity update(@MappingTarget UserEntity UserEntity, UserDTO UserDTO);
}
