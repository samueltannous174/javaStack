package org.example.world.Services;

import org.example.world.Models.CitiesEntity;
import org.example.world.Models.CountriesEntity;
import org.example.world.Repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public List<CitiesEntity> getMexicanBigCities() {
        return cityRepository.getCitiesByCountryPopulation("Mexico", 500000);
    }

    public List<Object[]> getArgentinaBigCities() {
        return cityRepository.getArgentinaBigCities();
    }
}
