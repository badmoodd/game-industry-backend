package com.amaizing.crudtemplate.controllers;

import com.amaizing.crudtemplate.models.GamePublisher;
import com.amaizing.crudtemplate.repositories.GamePublisherRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/v1/tables/game_publishers")
@AllArgsConstructor
public class GamePublisherController {

    private final GamePublisherRepository repository;

    @GetMapping
    public List<GamePublisher> getAll() {
        return repository.findAllByOrderByIdAsc();
    }

    @PostMapping
    public GamePublisher create(@RequestBody GamePublisher color) {
        return repository.save(color);
    }

    @PostMapping("/{id}")
    public GamePublisher update(@PathVariable("id") Long id, @RequestBody GamePublisher gamePublisher) {
        gamePublisher.setId(id);
        return repository.save(gamePublisher);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }


}