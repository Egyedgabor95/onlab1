package com.example.onlab_egyed_gabor.service.implementation;

import com.example.onlab_egyed_gabor.controller.dto.LeagueDTO;
import com.example.onlab_egyed_gabor.data.entities.LeagueEntity;
import com.example.onlab_egyed_gabor.data.mapper.LeagueMapper;
import com.example.onlab_egyed_gabor.data.repository.LeagueRepository;
import com.example.onlab_egyed_gabor.service.interfaces.ILeagueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
public class LeagueService implements ILeagueService {

    @Autowired
    private LeagueRepository leagueRepository;

    @Autowired
    private LeagueMapper leagueMapper;

    @Override
    public LeagueEntity create(LeagueDTO leagueDTO) {
        log.debug("LeagueService : create, LeagueDTO = {}", leagueDTO);
        return leagueRepository.save(leagueMapper.leagueDTOToLeagueEntity(leagueDTO));
    }

    @Override
    public List<LeagueDTO> read() {
        log.debug("LeagueService : read");
        return leagueMapper.leagueEntityListToLeagueDTOList(leagueRepository.findAll());
    }

    @Override
    public void update(Long targetId, LeagueDTO source) {
        log.debug("LeagueService : update, targetID = {}, source = {}", targetId, source);
        leagueMapper.update(findEntityById(targetId), source);
    }

    @Override
    public void delete(Long id) {
        log.debug("LeagueService : delete, id = {}", id);
        leagueRepository.delete(findEntityById(id));
    }

    @Override
    public LeagueDTO findById(Long id) {
        log.debug("LeagueService : delete, findById = {}", id);
        return leagueMapper.leagueEntityToLeagueDTO(leagueRepository.findById(id).orElseThrow(() -> new RuntimeException("Cannot find League with this id")));
    }

    private LeagueEntity findEntityById(Long id) {
        log.debug("LeagueService : findEntityById, id = {}", id);
        return leagueRepository.findById(id).orElseThrow(() -> new RuntimeException("Cannot find League with this id"));
    }
}
