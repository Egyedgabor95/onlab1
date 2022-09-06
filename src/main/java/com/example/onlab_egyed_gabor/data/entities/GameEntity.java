package com.example.onlab_egyed_gabor.data.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class GameEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    private TeamEntity home;
    @ManyToOne
    private TeamEntity away;
    @ManyToOne
    private RefereeEntity referee;
}
