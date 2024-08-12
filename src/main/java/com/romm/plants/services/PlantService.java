package com.romm.plants.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romm.plants.repositories.PlantRepository;

@Service
public class PlantService {
    
    @Autowired PlantRepository pr;

}
