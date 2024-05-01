package com.amaizing.crudtemplate.controllers;

import com.amaizing.crudtemplate.models.PlayerProgress;
import com.amaizing.crudtemplate.repositories.PlayerProgressRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/tables/player_progress")
@AllArgsConstructor
public class PlayerProgressController {

    private final PlayerProgressRepository repository;

    @GetMapping
    public List<PlayerProgress> getAll() {
        return repository.findAllByOrderByIdAsc();
    }

    @PostMapping
    public PlayerProgress create(@RequestBody PlayerProgress playerProgress) {
        return repository.save(playerProgress);
    }

    @PostMapping("/{id}")
    public PlayerProgress update(@PathVariable("id") Long id, @RequestBody PlayerProgress playerProgress) {
        playerProgress.setId(id);
        return repository.save(playerProgress);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }


}