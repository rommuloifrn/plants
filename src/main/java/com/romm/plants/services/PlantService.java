package com.romm.plants.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romm.plants.entities.Plant;
import com.romm.plants.repositories.PlantRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PlantService {
    
    @Autowired PlantRepository pr;

    public List<Plant> findAll() {
        return pr.findAll();
    }

    public Plant create(Plant plant) {
        return pr.save(plant);
    }

    public Plant findById(Long id) throws EntityNotFoundException {
        return findOrThrowNotFound(id);
    }

    public Plant updateById(Plant plant, Long id) throws EntityNotFoundException {
        plant.setId(id);
        var dbPlant = findOrThrowNotFound(id);
        if (plant.getTitle() != null) dbPlant.setTitle(plant.getTitle());
        if (plant.getPlantingDate() != null) dbPlant.setPlantingDate(plant.getPlantingDate());

        return pr.save(dbPlant);
    }

    public void delete(Long id) throws EntityNotFoundException {
        var plant = findOrThrowNotFound(id);
        pr.delete(plant);
    }

    public Plant findOrThrowNotFound (Long id) throws EntityNotFoundException {
        var opt = pr.findById(id);
        if (opt.isEmpty()) throw new EntityNotFoundException("There is not a plant with this id :(...");
        return opt.get();
    }
}
