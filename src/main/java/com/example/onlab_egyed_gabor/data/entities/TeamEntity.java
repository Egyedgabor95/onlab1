package com.example.onlab_egyed_gabor.data.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Entity
@Getter
@Setter
public class TeamEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @OneToMany
    private List<PlayerEntity> squad;
    @OneToMany
    private List<PlayerEntity> playingSquad;
    @OneToMany
    private List<PlayerEntity> starterEleven;
    @OneToMany
    private List<PlayerEntity> substitutions;
    private double value;
    @OneToOne
    private CoachEntity coach;
    private int points;
    private int goalsScored;
    private int goalsSuffered;
    @OneToMany
    private List<TeamEntity> playedWithTeamsList;
    private String managerName;
}
