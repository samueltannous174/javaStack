package org.example.world.Repositories;

import org.example.world.Models.CitiesEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CityRepository extends CrudRepository<CitiesEntity, Long> {
    @Query("SELECT ci FROM CitiesEntity ci JOIN ci.country c WHERE c.name = :country AND ci.population > :minPop ORDER BY ci.population DESC")
    List<CitiesEntity> getCitiesByCountryPopulation(@Param("country") String country, @Param("minPop") int minPop);

    @Query("SELECT c.name, ci.name, ci.district, ci.population FROM CitiesEntity ci JOIN ci.country c WHERE c.name = 'Argentina' AND ci.district = 'Buenos Aires' AND ci.population > 500000")
    List<Object[]> getArgentinaBigCities();


}