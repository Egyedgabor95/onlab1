package com.example.onlab_egyed_gabor.service.interfaces;

import com.example.onlab_egyed_gabor.controller.dto.TeamDTO;
import com.example.onlab_egyed_gabor.data.entities.TeamEntity;

import java.util.List;

public interface ITeamService {

    void create(TeamDTO teamDTO);

    List<TeamDTO> read();

    void update(int targetId, TeamDTO source);

    void delete(int id);

    TeamDTO findById(int id);
}