package com.amaizing.crudtemplate.repositories;

import com.amaizing.crudtemplate.models.GamePublisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GamePublisherRepository extends JpaRepository<GamePublisher, Long> {

    List<GamePublisher> findAllByOrderByIdAsc();
}
