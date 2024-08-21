package com.romm.plants.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import jakarta.persistence.EntityNotFoundException;

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
    public ResponseEntity<?> findById(@PathVariable("plantId") Long plantId) {
        try {
            return ResponseEntity.ok(ps.findById(plantId));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{plantId}")
    public ResponseEntity<?> updateById(@RequestBody Plant plant, @PathVariable("plantId") Long plantId) {
        try {
            return ResponseEntity.ok(ps.updateById(plant, plantId));    
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        
    }

    @DeleteMapping("/{plantId}")
    public ResponseEntity<?> deleteById(@PathVariable("plantId") Long plantId) {
        try {
            ps.delete(plantId);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok().build();
    }


}
