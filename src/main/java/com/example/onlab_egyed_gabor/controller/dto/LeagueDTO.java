package com.example.onlab_egyed_gabor.controller.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LeagueDTO {
    private int id;
    private List<TeamDTO> teams;
    private List<ManagerDTO> managers;
    private List<RefereeDTO> referees;
}
