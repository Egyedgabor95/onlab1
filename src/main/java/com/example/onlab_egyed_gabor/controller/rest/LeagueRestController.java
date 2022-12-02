package com.example.onlab_egyed_gabor.controller.rest;

import com.example.onlab_egyed_gabor.controller.dto.LeagueDTO;
import com.example.onlab_egyed_gabor.data.entities.LeagueEntity;
import com.example.onlab_egyed_gabor.service.implementation.LeagueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/league")
public class LeagueRestController {

    @Autowired
    private LeagueService leagueService;

    @PostMapping
    public ResponseEntity<LeagueEntity> create(@RequestBody LeagueDTO leagueDTO) {
        log.debug("LeagueRestController : create");
        return new ResponseEntity<>(leagueService.create(leagueDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<LeagueDTO>> read() {
        log.debug("LeagueRestController : read");
        return ResponseEntity.ok(leagueService.read());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeagueDTO> readOne(@PathVariable Long id) {
        log.debug("LeagueRestController : readOne");
        return ResponseEntity.ok(leagueService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody LeagueDTO leagueDTO) {
        log.debug("LeagueRestController : update");
        leagueService.update(id, leagueDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.debug("LeagueRestController : delete");
        leagueService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
