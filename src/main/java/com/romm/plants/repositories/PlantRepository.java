package com.romm.plants.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.romm.plants.entities.Plant;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Long> {
    
}
