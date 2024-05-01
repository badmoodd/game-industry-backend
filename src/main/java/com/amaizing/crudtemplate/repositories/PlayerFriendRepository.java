package com.amaizing.crudtemplate.repositories;

import com.amaizing.crudtemplate.models.PlayerFriend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerFriendRepository extends JpaRepository<PlayerFriend, Long> {

    List<PlayerFriend> findAllByOrderByIdAsc();
}
