package com.example.onlab_egyed_gabor.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ManagerDTO {

    private Long id;
    private String name;
    private int age;
    private TeamDTO team;
    private int happiness;
    private int rank;
}
