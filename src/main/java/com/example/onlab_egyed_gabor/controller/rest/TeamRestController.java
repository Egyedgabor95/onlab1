package com.example.onlab_egyed_gabor.controller.rest;

import com.example.onlab_egyed_gabor.controller.dto.TeamDTO;
import com.example.onlab_egyed_gabor.data.entities.TeamEntity;
import com.example.onlab_egyed_gabor.service.implementation.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/team")
public class TeamRestController {

    @Autowired
    private TeamService teamService;

    @PostMapping
    public ResponseEntity<TeamEntity> create(@RequestBody TeamDTO teamDTO) {
        log.debug("TeamRestController : create");
        return new ResponseEntity<>(teamService.create(teamDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TeamDTO>> read() {
        log.debug("TeamRestController : read");
        return ResponseEntity.ok(teamService.read());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamDTO> readOne(@PathVariable Long id) {
        log.debug("TeamRestController : readOne");
        return ResponseEntity.ok(teamService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody TeamDTO teamDTO) {
        log.debug("TeamRestController : update");
        teamService.update(id, teamDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.debug("TeamRestController : delete");
        teamService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
