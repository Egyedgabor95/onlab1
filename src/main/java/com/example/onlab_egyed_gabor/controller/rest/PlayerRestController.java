package com.example.onlab_egyed_gabor.controller.rest;

import com.example.onlab_egyed_gabor.controller.dto.PlayerDTO;
import com.example.onlab_egyed_gabor.data.entities.PlayerEntity;
import com.example.onlab_egyed_gabor.service.implementation.PlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/player")
public class PlayerRestController {

    @Autowired
    private PlayerService playerService;

    @PostMapping
    public ResponseEntity<PlayerEntity> create(@RequestBody PlayerDTO playerDTO) {
        log.debug("PlayerRestController : create");
        return new ResponseEntity<>(playerService.create(playerDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PlayerDTO>> read() {
        log.debug("PlayerRestController : read");
        return ResponseEntity.ok(playerService.read());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerDTO> readOne(@PathVariable Long id) {
        log.debug("PlayerRestController : readOne");
        return ResponseEntity.ok(playerService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody PlayerDTO playerDTO) {
        log.debug("PlayerRestController : update");
        playerService.update(id, playerDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.debug("PlayerRestController : delete");
        playerService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
