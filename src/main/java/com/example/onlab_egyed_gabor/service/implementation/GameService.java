package com.example.onlab_egyed_gabor.service.implementation;

import com.example.onlab_egyed_gabor.controller.dto.GameDTO;
import com.example.onlab_egyed_gabor.data.entities.GameEntity;
import com.example.onlab_egyed_gabor.data.mapper.GameMapper;
import com.example.onlab_egyed_gabor.data.repository.GameRepository;
import com.example.onlab_egyed_gabor.service.interfaces.IGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GameService implements IGameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private GameMapper gameMapper;

    @Override
    public void create(GameDTO gameDTO) {
        gameRepository.save(gameMapper.gameDTOToGameEntity(gameDTO));
    }

    @Override
    public List<GameDTO> read() {
        return gameMapper.gameEntityListToGameDTOList(gameRepository.findAll());
    }

    @Override
    public void update(Long targetId, GameDTO source) {
        gameMapper.update(findEntityById(targetId), source);
    }

    @Override
    public void delete(Long id) {
        gameRepository.delete(findEntityById(id));
    }

    @Override
    public GameDTO findById(Long id) {
        return gameMapper.gameEntityToGameDTO(gameRepository.findById(id).orElseThrow(() -> new RuntimeException("Cannot find game with this id")));
    }

    private GameEntity findEntityById(Long id) {
        return gameRepository.findById(id).orElseThrow(() -> new RuntimeException("Cannot find game with this id"));
    }
}
