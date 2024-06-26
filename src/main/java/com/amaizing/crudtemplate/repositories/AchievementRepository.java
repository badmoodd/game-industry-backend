package com.amaizing.crudtemplate.repositories;

import com.amaizing.crudtemplate.models.Achievement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AchievementRepository extends JpaRepository<Achievement, Long> {

    List<Achievement> findAllByOrderByIdAsc();
}

