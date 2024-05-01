package com.amaizing.crudtemplate.repositories;

import com.amaizing.crudtemplate.models.PlayerInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerInventoryRepository extends JpaRepository<PlayerInventory, Long> {

    List<PlayerInventory> findAllByOrderByIdAsc();
}
