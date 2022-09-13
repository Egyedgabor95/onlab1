package com.example.onlab_egyed_gabor.controller.rest;

import com.example.onlab_egyed_gabor.controller.dto.CoachDTO;
import com.example.onlab_egyed_gabor.data.entities.CoachEntity;
import com.example.onlab_egyed_gabor.service.implementation.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/coach")
public class CoachRestController {

    @Autowired
    private CoachService coachService;

    @PostMapping
    public List<CoachDTO> create(@RequestBody CoachDTO coachDTO) {
        coachService.create(coachDTO);
        return coachService.read();
    }

    @GetMapping
    public List<CoachDTO> read() {
        return coachService.read();
    }

    @PutMapping("/{id}")
    public List<CoachDTO> update(@PathVariable int id, @RequestBody CoachDTO coachDTO) {
        coachService.update(id, coachDTO);
        return coachService.read();
    }

    @DeleteMapping("/{id}")
    public List<CoachDTO> delete(@PathVariable int id) {
        coachService.delete(id);
        return coachService.read();
    }
}
