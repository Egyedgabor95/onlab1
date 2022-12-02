package com.example.onlab_egyed_gabor.data.repository;

import com.example.onlab_egyed_gabor.data.entities.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {
}
