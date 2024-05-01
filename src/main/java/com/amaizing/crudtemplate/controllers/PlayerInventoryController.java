package com.amaizing.crudtemplate.controllers;

import com.amaizing.crudtemplate.models.PlayerInventory;
import com.amaizing.crudtemplate.repositories.PlayerInventoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/tables/player_inventory")
@AllArgsConstructor
public class PlayerInventoryController {

    private final PlayerInventoryRepository repository;

    @GetMapping
    public List<PlayerInventory> getAll() {
        return repository.findAllByOrderByIdAsc();
    }

    @PostMapping
    public PlayerInventory create(@RequestBody PlayerInventory playerInventory) {
        return repository.save(playerInventory);
    }

    @PostMapping("/{id}")
    public PlayerInventory update(@PathVariable("id") Long id, @RequestBody PlayerInventory playerInventory) {
        playerInventory.setId(id);
        return repository.save(playerInventory);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }


}