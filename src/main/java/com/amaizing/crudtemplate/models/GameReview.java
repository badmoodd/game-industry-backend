package com.amaizing.crudtemplate.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "game_reviews")
@Getter
@Setter
@NoArgsConstructor
public class GameReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long id;

    @Column(name = "game_name")
    private String gameName;

    @Column(name = "player_id")
    private String playerId;

    @Column(name = "rating")
    private int rating;

    @Column(name = "review_text", columnDefinition = "TEXT")
    private String reviewText;

}
