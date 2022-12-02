package com.example.onlab_egyed_gabor.controller.rest;

import com.example.onlab_egyed_gabor.controller.dto.CoachDTO;
import com.example.onlab_egyed_gabor.data.entities.CoachEntity;
import com.example.onlab_egyed_gabor.service.implementation.CoachService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/coach")
public class CoachRestController {

    @Autowired
    private CoachService coachService;

    @PostMapping
    public ResponseEntity<CoachEntity> create(@RequestBody CoachDTO coachDTO) {
        log.debug("CoachRestController : create");
        return new ResponseEntity<>(coachService.create(coachDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CoachDTO>> read() {
        log.debug("CoachRestController : read");
        return ResponseEntity.ok(coachService.read());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CoachDTO> readOne(@PathVariable Long id) {
        log.debug("CoachRestController : readOne");
        return ResponseEntity.ok(coachService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody CoachDTO coachDTO) {
        log.debug("CoachRestController : update");
        coachService.update(id, coachDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.debug("CoachRestController : delete");
        coachService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
