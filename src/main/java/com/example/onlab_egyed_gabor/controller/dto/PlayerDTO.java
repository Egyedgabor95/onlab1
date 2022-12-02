package com.example.onlab_egyed_gabor.controller.dto;

import com.example.onlab_egyed_gabor.data.enums.Position;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerDTO {
    private Long id;
    private String name;
    private Position position;
    private int playerNumber;
    private double value;
    private double salary;
    private int contractDeadline;
    private int age;
    private int skillPoint;
    private int health;
    private int redCardCounter;
}
