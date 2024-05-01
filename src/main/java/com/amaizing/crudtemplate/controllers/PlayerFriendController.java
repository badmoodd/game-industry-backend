package com.amaizing.crudtemplate.controllers;

import com.amaizing.crudtemplate.models.PlayerFriend;
import com.amaizing.crudtemplate.repositories.PlayerFriendRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/tables/player_friends")
@AllArgsConstructor
public class PlayerFriendController {

    private final PlayerFriendRepository repository;

    @GetMapping
    public List<PlayerFriend> getAll() {
        return repository.findAllByOrderByIdAsc();
    }

    @PostMapping
    public PlayerFriend create(@RequestBody PlayerFriend playerFriend) {
        return repository.save(playerFriend);
    }

    @PostMapping("/{id}")
    public PlayerFriend update(@PathVariable("id") Long id, @RequestBody PlayerFriend playerFriend) {
        playerFriend.setId(id);
        return repository.save(playerFriend);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }


}