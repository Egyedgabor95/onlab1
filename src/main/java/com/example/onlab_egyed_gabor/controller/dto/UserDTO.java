package com.example.onlab_egyed_gabor.controller.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserDTO {

    private Long id;
    private String username;
    private String password;
    private String roles;
}
