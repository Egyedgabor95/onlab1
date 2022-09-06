package com.example.onlab_egyed_gabor.controller.dto;

import java.util.List;

public class TeamDTO {
    private int id;
    private String name;
    private List<PlayerDTO> squad;
    private List<PlayerDTO> playingSquad;
    private List<PlayerDTO> starterEleven;
    private List<PlayerDTO> substitutions;
    private double value;
    private CoachDTO coach;
    private int points;
    private int goalsScored;
    private int goalsSuffered;
    private List<TeamDTO> playedWithTeamsList;
    private String managerName;
}
