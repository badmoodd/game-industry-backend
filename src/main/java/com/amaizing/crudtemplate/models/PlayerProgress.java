package com.amaizing.crudtemplate.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "player_progress")
@Getter
@Setter
@NoArgsConstructor
public class PlayerProgress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "progress_id")
    private Long id;

    @Column(name = "player_name")
    private String playerName;

    @Column(name = "game_name")
    private String gameName;

    @Column(name = "current_level")
    private int currentLevel;

    @Column(name = "experience")
    private int experience;

    // Constructors, getters, and setters
}