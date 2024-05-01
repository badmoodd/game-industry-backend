package com.amaizing.crudtemplate.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "game_publishers")
@Getter
@Setter
@NoArgsConstructor
public class GamePublisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "country")
    private String country;

    // Constructors, getters, and setters
}
