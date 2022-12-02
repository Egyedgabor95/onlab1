package com.example.onlab_egyed_gabor.service.implementation;

import com.example.onlab_egyed_gabor.controller.dto.GameDTO;
import com.example.onlab_egyed_gabor.data.entities.GameEntity;
import com.example.onlab_egyed_gabor.data.mapper.GameMapper;
import com.example.onlab_egyed_gabor.data.repository.GameRepository;
import com.example.onlab_egyed_gabor.service.interfaces.IGameService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
public class GameService implements IGameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private GameMapper gameMapper;

    @Override
    public GameEntity create(GameDTO gameDTO) {
        log.debug("GameService : create, gameDTO = {}", gameDTO);
        return gameRepository.save(gameMapper.gameDTOToGameEntity(gameDTO));
    }

    @Override
    public List<GameDTO> read() {
        log.debug("GameService : read");
        return gameMapper.gameEntityListToGameDTOList(gameRepository.findAll());
    }

    @Override
    public void update(Long targetId, GameDTO source) {
        log.debug("GameService : update, targetID = {}, source = {}", targetId, source);
        gameMapper.update(findEntityById(targetId), source);
    }

    @Override
    public void delete(Long id) {
        log.debug("GameService : delete, id = {}", id);
        gameRepository.delete(findEntityById(id));
    }

    @Override
    public GameDTO findById(Long id) {
        log.debug("GameService : delete, findById = {}", id);
        return gameMapper.gameEntityToGameDTO(gameRepository.findById(id).orElseThrow(() -> new RuntimeException("Cannot find game with this id")));
    }

    private GameEntity findEntityById(Long id) {
        log.debug("GameService : findEntityById, id = {}", id);
        return gameRepository.findById(id).orElseThrow(() -> new RuntimeException("Cannot find game with this id"));
    }
}
