package com.example.onlab_egyed_gabor.service.implementation;

import com.example.onlab_egyed_gabor.data.repository.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LeagueService {

    @Autowired
    private LeagueRepository leagueRepository;
}
