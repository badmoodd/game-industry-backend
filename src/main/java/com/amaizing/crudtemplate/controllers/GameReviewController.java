package com.amaizing.crudtemplate.controllers;

import com.amaizing.crudtemplate.models.GameReview;
import com.amaizing.crudtemplate.repositories.GameReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/tables/game_reviews")
@AllArgsConstructor
public class GameReviewController {

    private final GameReviewRepository repository;

    @GetMapping
    public List<GameReview> getAll() {
        return repository.findAllByOrderByIdAsc();
    }

    @PostMapping
    public GameReview create(@RequestBody GameReview gameReview) {
        return repository.save(gameReview);
    }

    @PostMapping("/{id}")
    public GameReview update(@PathVariable("id") Long id, @RequestBody GameReview gameReview) {
        gameReview.setId(id);
        return repository.save(gameReview);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }


}