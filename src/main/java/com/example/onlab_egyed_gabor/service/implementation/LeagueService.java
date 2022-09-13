package com.example.onlab_egyed_gabor.service.implementation;

import com.example.onlab_egyed_gabor.data.repository.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeagueService {

    @Autowired
    private LeagueRepository leagueRepository;
}
