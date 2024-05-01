package com.amaizing.crudtemplate.controllers;

import com.amaizing.crudtemplate.models.Achievement;
import com.amaizing.crudtemplate.repositories.AchievementRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tables/achievements")
@AllArgsConstructor
public class AchievementController {

    private final AchievementRepository repository;

    @GetMapping
    public List<Achievement> getAll() {
        return repository.findAllByOrderByIdAsc();
    }

    @PostMapping
    public Achievement create(@RequestBody Achievement achievement) {
        return repository.save(achievement);
    }

    @PostMapping("/{id}")
    public Achievement update(@PathVariable("id") Long id, @RequestBody Achievement achievement) {
        achievement.setId(id);
        return repository.save(achievement);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }


}
