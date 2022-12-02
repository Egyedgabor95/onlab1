package com.example.onlab_egyed_gabor.service.interfaces;

import com.example.onlab_egyed_gabor.controller.dto.UserDTO;
import com.example.onlab_egyed_gabor.data.entities.UserEntity;

import java.util.List;

public interface IUserService {

    UserEntity create(UserDTO UserDTO);

    List<UserDTO> read();

    void update(Long targetId, UserDTO source);

    void delete(Long id);

    UserDTO findById(Long id);
}