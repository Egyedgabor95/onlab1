package com.example.onlab_egyed_gabor.service.implementation;

import com.example.onlab_egyed_gabor.controller.dto.PlayerDTO;
import com.example.onlab_egyed_gabor.data.entities.PlayerEntity;
import com.example.onlab_egyed_gabor.data.mapper.PlayerMapper;
import com.example.onlab_egyed_gabor.data.repository.PlayerRepository;
import com.example.onlab_egyed_gabor.service.interfaces.IPlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
public class PlayerService implements IPlayerService {

    @Autowired
    private PlayerRepository playerrepository;

    @Autowired
    private PlayerMapper playerMapper;

    @Override
    public PlayerEntity create(PlayerDTO playerDTO) {
        log.debug("PlayerService : create, PlayerDTO = {}", playerDTO);
        return playerrepository.save(playerMapper.playerDTOToPlayerEntity(playerDTO));
    }

    @Override
    public List<PlayerDTO> read() {
        log.debug("PlayerService : read");
        return playerMapper.playerEntityListToPlayerDTOList(playerrepository.findAll());
    }

    @Override
    public void update(Long targetId, PlayerDTO source) {
        log.debug("PlayerService : update, targetID = {}, source = {}", targetId, source);
        playerMapper.update(findEntityById(targetId), source);
    }

    @Override
    public void delete(Long id) {
        log.debug("PlayerService : delete, id = {}", id);
        playerrepository.delete(findEntityById(id));
    }

    @Override
    public PlayerDTO findById(Long id) {
        log.debug("PlayerService : delete, findById = {}", id);
        return playerMapper.playerEntityToPlayerDTO(playerrepository.findById(id).orElseThrow(() -> new RuntimeException("Cannot find Player with this id")));
    }

    private PlayerEntity findEntityById(Long id) {
        log.debug("PlayerService : findEntityById, id = {}", id);
        return playerrepository.findById(id).orElseThrow(() -> new RuntimeException("Cannot find Player with this id"));
    }
}
