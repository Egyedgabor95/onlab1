package com.example.onlab_egyed_gabor.data.entities;

import java.util.List;

public class TeamEntity {

    private int id;

    private String name;

    private List<PlayerEntity> squad;
    private List<PlayerEntity> playingSquad;
    private List<PlayerEntity> starterEleven;
    private List<PlayerEntity> substitutions;

    private double value;

    private CoachEntity coach;

    private int points;
    private int goalsScored;
    private int goalsSuffered;

    private List<TeamEntity> playedWithTeamsList;

    private String managerName;
}
