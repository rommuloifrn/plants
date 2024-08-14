package com.romm.plants.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.romm.plants.entities.Plant;
import com.romm.plants.services.PlantService;

@RestController
@RequestMapping(value="")
public class PlantController {
    
    @Autowired PlantService ps;

    @GetMapping
    public List<Plant> findAll() {
        return ps.findAll();
    }

    @PostMapping
    public Plant create(@RequestBody Plant plant) {
        return ps.create(plant);
    }

    @GetMapping("/{plantId}")
    public Plant findById(@PathVariable("plantId") Long plantId) {
        return ps.findById(plantId);
    }

    @PutMapping("/{plantId}")
    public Plant updateById(@RequestBody Plant plant, @PathVariable("plantId") Long plantId) {
        plant.setId(plantId);
        return ps.updateById(plant, plantId);
    }

    @DeleteMapping("/{plantId}")
    public ResponseEntity<?> deleteById(@PathVariable("plantId") Long plantId) {
        ps.delete(plantId);

        return ResponseEntity.ok().build();
    }


}
