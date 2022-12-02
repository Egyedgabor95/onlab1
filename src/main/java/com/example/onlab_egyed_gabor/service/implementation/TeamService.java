package com.example.onlab_egyed_gabor.service.implementation;

import com.example.onlab_egyed_gabor.controller.dto.TeamDTO;
import com.example.onlab_egyed_gabor.data.entities.TeamEntity;
import com.example.onlab_egyed_gabor.data.mapper.TeamMapper;
import com.example.onlab_egyed_gabor.data.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private TeamMapper teamMapper;

    public void create(TeamDTO teamDTO) {
        teamRepository.save(teamMapper.teamDTOToTeamEntity(teamDTO));
    }

    public List<TeamEntity> read() {
        return teamRepository.findAll();
    }

    public void update(TeamDTO newTeam) {
        //TODO
    }

    public void delete(TeamDTO teamDTO) {
        teamRepository.deleteById(teamMapper.teamDTOToTeamEntity(teamDTO).getId());
    }
}
