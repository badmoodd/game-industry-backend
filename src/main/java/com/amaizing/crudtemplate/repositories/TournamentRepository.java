package com.amaizing.crudtemplate.repositories;

import com.amaizing.crudtemplate.models.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Long> {

    List<Tournament> findAllByOrderByIdAsc();
}
