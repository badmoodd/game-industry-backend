package com.amaizing.crudtemplate.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "player_inventory")
@Getter
@Setter
@NoArgsConstructor
public class PlayerInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id")
    private Long id;

    @Column(name = "player_name")
    private String playerName;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "quantity")
    private int quantity;

}
