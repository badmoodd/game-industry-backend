package com.amaizing.crudtemplate.controllers;

import com.amaizing.crudtemplate.models.Tournament;
import com.amaizing.crudtemplate.repositories.TournamentRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/v1/tables/tournaments")
@AllArgsConstructor
public class TournamentController {

    private final TournamentRepository repository;

    @GetMapping
    public List<Tournament> getAll() {
        return repository.findAllByOrderByIdAsc();
    }

    @PostMapping
    public Tournament create(@RequestBody Tournament tournament) {
        return repository.save(tournament);
    }

    @PostMapping("/{id}")
    public Tournament update(@PathVariable("id") Long id, @RequestBody Tournament tournament) {
        tournament.setId(id);
        return repository.save(tournament);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }


}