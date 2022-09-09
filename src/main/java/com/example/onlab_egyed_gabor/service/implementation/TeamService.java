package com.example.onlab_egyed_gabor.service.implementation;

import com.example.onlab_egyed_gabor.controller.dto.TeamDTO;
import com.example.onlab_egyed_gabor.data.entities.TeamEntity;
import com.example.onlab_egyed_gabor.data.mapper.TeamMapper;
import com.example.onlab_egyed_gabor.data.repository.TeamRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    private TeamMapper teamMapper;

    public void create(TeamDTO teamDTO) {
        getTeamRepository().save(getTeamMapper().teamDTOToTeamEntity(teamDTO));
    }

    public List<TeamEntity> read() {
        return getTeamRepository().findAll();
    }

    public void update(TeamDTO newTeam) {
        //TODO
    }

    public void delete(TeamDTO teamDTO) {
        getTeamRepository().deleteById(getTeamMapper().teamDTOToTeamEntity(teamDTO).getId());
    }
}
