package com.example.onlab_egyed_gabor.controller.rest;

import com.example.onlab_egyed_gabor.controller.dto.GameDTO;
import com.example.onlab_egyed_gabor.data.entities.GameEntity;
import com.example.onlab_egyed_gabor.service.implementation.GameService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/game")
public class GameRestController {

    @Autowired
    private GameService gameService;

    @PostMapping
    public ResponseEntity<GameEntity> create(@RequestBody GameDTO gameDTO) {
        log.debug("gameRestController : create");
        return new ResponseEntity<>(gameService.create(gameDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<GameDTO>> read() {
        log.debug("gameRestController : read");
        return ResponseEntity.ok(gameService.read());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameDTO> readOne(@PathVariable Long id) {
        log.debug("gameRestController : readOne");
        return ResponseEntity.ok(gameService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody GameDTO gameDTO) {
        log.debug("gameRestController : update");
        gameService.update(id, gameDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.debug("gameRestController : delete");
        gameService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
