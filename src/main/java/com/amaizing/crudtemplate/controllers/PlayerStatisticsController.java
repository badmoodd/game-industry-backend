package com.amaizing.crudtemplate.controllers;

import com.amaizing.crudtemplate.models.PlayerStatistics;
import com.amaizing.crudtemplate.repositories.PlayerStatisticsRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/v1/tables/player_statistics")
@AllArgsConstructor
public class PlayerStatisticsController {

    private final PlayerStatisticsRepository repository;

    @GetMapping
    public List<PlayerStatistics> getAll() {
        return repository.findAllByOrderByIdAsc();
    }

    @PostMapping
    public PlayerStatistics create(@RequestBody PlayerStatistics playerStatistics) {
        return repository.save(playerStatistics);
    }

    @PostMapping("/{id}")
    public PlayerStatistics update(@PathVariable("id") Long id, @RequestBody PlayerStatistics playerStatistics) {
        playerStatistics.setId(id);
        return repository.save(playerStatistics);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }


}