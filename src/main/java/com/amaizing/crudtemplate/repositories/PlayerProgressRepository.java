package com.amaizing.crudtemplate.repositories;

import com.amaizing.crudtemplate.models.PlayerProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerProgressRepository extends JpaRepository<PlayerProgress, Long> {

    List<PlayerProgress> findAllByOrderByIdAsc();
}
