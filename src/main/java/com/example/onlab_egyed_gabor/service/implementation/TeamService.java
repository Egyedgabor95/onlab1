package com.example.onlab_egyed_gabor.service.implementation;

import com.example.onlab_egyed_gabor.controller.dto.TeamDTO;
import com.example.onlab_egyed_gabor.data.entities.TeamEntity;
import com.example.onlab_egyed_gabor.data.mapper.TeamMapper;
import com.example.onlab_egyed_gabor.data.repository.TeamRepository;
import com.example.onlab_egyed_gabor.service.interfaces.ITeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
public class TeamService implements ITeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private TeamMapper teamMapper;

    @Override
    public TeamEntity create(TeamDTO teamDTO) {
        log.debug("TeamService : create, TeamDTO = {}", teamDTO);
        return teamRepository.save(teamMapper.teamDTOToTeamEntity(teamDTO));
    }

    @Override
    public List<TeamDTO> read() {
        log.debug("TeamService : read");
        return teamMapper.teamEntityListToTeamDTOList(teamRepository.findAll());
    }

    @Override
    public void update(Long targetId, TeamDTO source) {
        log.debug("TeamService : update, targetID = {}, source = {}", targetId, source);
        teamMapper.update(findEntityById(targetId), source);
    }

    @Override
    public void delete(Long id) {
        log.debug("TeamService : delete, id = {}", id);
        teamRepository.delete(findEntityById(id));
    }

    @Override
    public TeamDTO findById(Long id) {
        log.debug("TeamService : delete, findById = {}", id);
        return teamMapper.teamEntityToTeamDTO(teamRepository.findById(id).orElseThrow(() -> new RuntimeException("Cannot find Team with this id")));
    }

    private TeamEntity findEntityById(Long id) {
        log.debug("TeamService : findEntityById, id = {}", id);
        return teamRepository.findById(id).orElseThrow(() -> new RuntimeException("Cannot find Team with this id"));
    }
}
