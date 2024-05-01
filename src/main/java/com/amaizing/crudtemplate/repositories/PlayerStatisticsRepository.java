package com.amaizing.crudtemplate.repositories;

import com.amaizing.crudtemplate.models.PlayerStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerStatisticsRepository extends JpaRepository<PlayerStatistics, Long> {

    List<PlayerStatistics> findAllByOrderByIdAsc();
}
