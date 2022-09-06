package com.example.onlab_egyed_gabor.data.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class ManagerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String name;
    private int age;

    @OneToOne
    private TeamEntity team;
    private int happiness;
    private int rank;
}
