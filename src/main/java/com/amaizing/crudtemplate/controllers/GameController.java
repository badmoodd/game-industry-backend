package com.amaizing.crudtemplate.controllers;

import com.amaizing.crudtemplate.models.Game;
import com.amaizing.crudtemplate.repositories.GameRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/tables/games")
@AllArgsConstructor
public class GameController {

    private final GameRepository repository;

    @GetMapping
    public List<Game> getAll() {
        return repository.findAllByOrderByIdAsc();
    }

    @PostMapping
    public Game create(@RequestBody Game game) {
        return repository.save(game);
    }

    @PostMapping("/{id}")
    public Game update(@PathVariable("id") Long id, @RequestBody Game game) {
        game.setId(id);
        return repository.save(game);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }


}