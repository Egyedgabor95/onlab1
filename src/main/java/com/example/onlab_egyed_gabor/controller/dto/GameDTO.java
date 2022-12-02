package com.example.onlab_egyed_gabor.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameDTO {
    private Long id;
    private TeamDTO home;
    private TeamDTO away;
    private RefereeDTO referee;
}
