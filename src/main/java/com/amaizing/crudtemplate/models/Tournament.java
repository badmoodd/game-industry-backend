package com.amaizing.crudtemplate.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "tournaments")
@Getter
@Setter
@NoArgsConstructor
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tournament_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "game_name")
    private String gameName;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "organizer")
    private String organizer;

    // Constructors, getters, and setters
}
