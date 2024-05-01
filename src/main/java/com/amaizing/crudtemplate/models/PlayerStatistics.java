package com.amaizing.crudtemplate.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "player_statistics")
@Getter
@Setter
@NoArgsConstructor
public class PlayerStatistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stat_id")
    private Long id;

    @Column(name = "player_name")
    private String playerName;

    @Column(name = "game_name")
    private String gameName;

    @Column(name = "wins")
    private int wins;

    @Column(name = "losses")
    private int losses;

    @Column(name = "draws")
    private int draws;

    @Column(name = "points")
    private int points;

}