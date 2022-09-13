package com.example.onlab_egyed_gabor.service.implementation;

import com.example.onlab_egyed_gabor.data.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;
}
