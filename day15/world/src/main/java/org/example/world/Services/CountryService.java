package org.example.world.Services;

import org.example.world.Models.CountriesEntity;
import org.example.world.Repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Object[]> getCountriesSpeaking(String lang) {
        return countryRepository.getCountriesByLanguage(lang);
    }

    public List<Object[]> getCityCounts() {
        return countryRepository.getCityCounts();
    }

    public List<CountriesEntity> getSmallButPopulatedCountries() {
        return countryRepository.findBySurfaceAreaLessThanAndPopulationGreaterThan(501, 100000);
    }

    public List<CountriesEntity> getConstitutionalMonarchies() {
        return countryRepository.findByGovernmentFormAndSurfaceAreaGreaterThanAndLifeExpectancyGreaterThan(
                "Constitutional Monarchy", 200, 75
        );
    }

    public List<Object[]> getCountCountriesByRegion(){
        return countryRepository.countCountriesByRegion();
    }
}
