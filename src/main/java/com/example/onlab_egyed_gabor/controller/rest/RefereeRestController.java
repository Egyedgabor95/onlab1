package com.example.onlab_egyed_gabor.controller.rest;

import com.example.onlab_egyed_gabor.controller.dto.RefereeDTO;
import com.example.onlab_egyed_gabor.data.entities.RefereeEntity;
import com.example.onlab_egyed_gabor.service.implementation.RefereeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/referee")
public class RefereeRestController {

    @Autowired
    private RefereeService refereeService;

    @PostMapping
    public ResponseEntity<RefereeEntity> create(@RequestBody RefereeDTO refereeDTO) {
        log.debug("RefereeRestController : create");
        return new ResponseEntity<>(refereeService.create(refereeDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RefereeDTO>> read() {
        log.debug("RefereeRestController : read");
        return ResponseEntity.ok(refereeService.read());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RefereeDTO> readOne(@PathVariable Long id) {
        log.debug("RefereeRestController : readOne");
        return ResponseEntity.ok(refereeService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody RefereeDTO refereeDTO) {
        log.debug("RefereeRestController : update");
        refereeService.update(id, refereeDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.debug("RefereeRestController : delete");
        refereeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
