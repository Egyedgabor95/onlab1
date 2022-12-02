package com.example.onlab_egyed_gabor.data.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Entity
@Getter
@Setter
public class LeagueEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany
    private List<TeamEntity> teams;
    @OneToMany
    private List<ManagerEntity> managers;
    @OneToMany
    private List<RefereeEntity> referees;
}
