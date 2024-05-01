package com.amaizing.crudtemplate.controllers;

import com.amaizing.crudtemplate.models.TableEntry;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;



@RestController
@RequestMapping("/api/v1/tables")
@AllArgsConstructor
public class TableController {

    @GetMapping
    public List<TableEntry> getTables() {
        List<TableEntry> tables = new ArrayList<>();

        tables.add(new TableEntry("Достижения", "/api/v1/tables/achievements", "achievements"));
        tables.add(new TableEntry("Игры", "/api/v1/tables/games", "games"));
        tables.add(new TableEntry("Издатели", "/api/v1/tables/game_publishers", "game_publishers"));
        tables.add(new TableEntry("Отзывы", "/api/v1/tables/game_reviews", "game_reviews"));
        tables.add(new TableEntry("Игроки", "/api/v1/tables/players", "players"));
        tables.add(new TableEntry("Друзья игроков", "/api/v1/tables/player_friends", "player_friends"));
        tables.add(new TableEntry("Инвентарь игроков", "/api/v1/tables/player_inventory", "player_inventory"));
        tables.add(new TableEntry("Прогресс игроков", "/api/v1/tables/player_progress", "player_progress"));
        tables.add(new TableEntry("Статистика игроков", "/api/v1/tables/player_statistics", "player_statistics"));
        tables.add(new TableEntry("Турниры", "/api/v1/tables/tournaments", "tournaments"));

        return tables;
    }


}