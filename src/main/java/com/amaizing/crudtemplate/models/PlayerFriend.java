package com.amaizing.crudtemplate.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "player_friends")
@Getter
@Setter
@NoArgsConstructor
public class PlayerFriend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "friendship_id")
    private Long id;

    @Column(name = "player_name")
    private String playerName;

    @Column(name = "friend_name")
    private String friendName;

}
