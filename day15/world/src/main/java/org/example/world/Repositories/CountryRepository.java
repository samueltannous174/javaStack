package org.example.world.Repositories;

import org.example.world.Models.CitiesEntity;
import org.example.world.Models.CountriesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CountryRepository extends CrudRepository<CountriesEntity, Long> {
    @Query("SELECT c.name, l.language, l.percentage FROM CountriesEntity c JOIN c.languages l WHERE l.language = :lang ORDER BY l.percentage DESC")
    List<Object[]> getCountriesByLanguage(@Param("lang") String lang);

    @Query("SELECT c.name, COUNT(ci.id) FROM CountriesEntity c JOIN c.cities ci GROUP BY c.id ORDER BY COUNT(ci.id) DESC")
    List<Object[]> getCityCounts();

    List<CountriesEntity> findBySurfaceAreaLessThanAndPopulationGreaterThan(double area, int population);

    List<CountriesEntity> findByGovernmentFormAndSurfaceAreaGreaterThanAndLifeExpectancyGreaterThan(
            String govForm, double area, double lifeExp);

    @Query("SELECT c.region, COUNT(c) FROM CountriesEntity c GROUP BY c.region ORDER BY COUNT(c) DESC")
    List<Object[]> countCountriesByRegion();


}