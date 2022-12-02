package com.example.onlab_egyed_gabor.service.interfaces;

import com.example.onlab_egyed_gabor.controller.dto.TeamDTO;
import com.example.onlab_egyed_gabor.data.entities.TeamEntity;

import java.util.List;

public interface ITeamService {

    TeamEntity create(TeamDTO teamDTO);

    List<TeamDTO> read();

    void update(Long targetId, TeamDTO source);

    void delete(Long id);

    TeamDTO findById(Long id);
}