package com.example.onlab_egyed_gabor.service.interfaces;

import com.example.onlab_egyed_gabor.controller.dto.LeagueDTO;
import com.example.onlab_egyed_gabor.data.entities.LeagueEntity;

import java.util.List;

public interface ILeagueService {

    void create(LeagueDTO leagueDTO);

    List<LeagueEntity> read();

    void update(int targetId, LeagueDTO source);

    void delete(int id);

    LeagueEntity findById(int id);
}
