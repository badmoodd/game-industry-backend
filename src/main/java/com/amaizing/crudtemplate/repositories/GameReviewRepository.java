package com.amaizing.crudtemplate.repositories;

import com.amaizing.crudtemplate.models.GameReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameReviewRepository extends JpaRepository<GameReview, Long> {

    List<GameReview> findAllByOrderByIdAsc();
}
