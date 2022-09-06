package com.example.onlab_egyed_gabor.data.entities;

import com.example.onlab_egyed_gabor.data.enums.Position;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class PlayerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
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
