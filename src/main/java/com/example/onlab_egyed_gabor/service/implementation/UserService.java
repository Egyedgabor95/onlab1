package com.example.onlab_egyed_gabor.service.implementation;

import com.example.onlab_egyed_gabor.controller.dto.UserDTO;
import com.example.onlab_egyed_gabor.data.entities.UserEntity;
import com.example.onlab_egyed_gabor.data.mapper.UserMapper;
import com.example.onlab_egyed_gabor.data.repository.UserRepository;
import com.example.onlab_egyed_gabor.service.interfaces.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserEntity create(UserDTO userDTO) {
        log.debug("UserService : create, UserDTO = {}", userDTO);
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        UserEntity newUser = new UserEntity(userDTO.getUsername(), encoder.encode(userDTO.getPassword()), userDTO.getRoles());
        return userRepository.save(newUser);
    }

    @Override
    public List<UserDTO> read() {
        log.debug("UserService : read");
        return userMapper.userEntityListToUserDTOList(userRepository.findAll());
    }

    @Override
    public void update(Long targetId, UserDTO source) {
        log.debug("UserService : update, targetID = {}, source = {}", targetId, source);
        userMapper.update(findEntityById(targetId), source);
    }

    @Override
    public void delete(Long id) {
        log.debug("UserService : delete, id = {}", id);
        userRepository.delete(findEntityById(id));
    }

    @Override
    public UserDTO findById(Long id) {
        log.debug("UserService : delete, findById = {}", id);
        return userMapper.userEntityToUserDTO(userRepository.findById(id).orElseThrow(() -> new RuntimeException("Cannot find User with this id")));
    }

    private UserEntity findEntityById(Long id) {
        log.debug("UserService : findEntityById, id = {}", id);
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Cannot find User with this id"));
    }
}
