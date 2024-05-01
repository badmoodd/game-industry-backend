package com.amaizing.crudtemplate.controllers;

import com.amaizing.crudtemplate.models.Player;
import com.amaizing.crudtemplate.repositories.PlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/tables/players")
@AllArgsConstructor
public class PlayerController {

    private final PlayerRepository repository;

    @GetMapping
    public List<Player> getAll() {
        return repository.findAllByOrderByIdAsc();
    }

    @PostMapping
    public Player create(@RequestBody Player player) {
        return repository.save(player);
    }

    @PostMapping("/{id}")
    public Player update(@PathVariable("id") Long id, @RequestBody Player player) {
        player.setId(id);
        return repository.save(player);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }


}