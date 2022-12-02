package com.example.onlab_egyed_gabor.controller.rest;

import com.example.onlab_egyed_gabor.controller.dto.ManagerDTO;
import com.example.onlab_egyed_gabor.data.entities.ManagerEntity;
import com.example.onlab_egyed_gabor.service.implementation.ManagerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/manager")
public class ManagerRestController {

    @Autowired
    private ManagerService managerService;

    @PostMapping
    public ResponseEntity<ManagerEntity> create(@RequestBody ManagerDTO managerDTO) {
        log.debug("ManagerRestController : create");
        return new ResponseEntity<>(managerService.create(managerDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ManagerDTO>> read() {
        log.debug("ManagerRestController : read");
        return ResponseEntity.ok(managerService.read());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ManagerDTO> readOne(@PathVariable Long id) {
        log.debug("ManagerRestController : readOne");
        return ResponseEntity.ok(managerService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody ManagerDTO managerDTO) {
        log.debug("ManagerRestController : update");
        managerService.update(id, managerDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.debug("ManagerRestController : delete");
        managerService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
