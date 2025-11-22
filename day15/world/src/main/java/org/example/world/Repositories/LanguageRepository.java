package org.example.world.Repositories;

import org.example.world.Models.LanguagesEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LanguageRepository extends CrudRepository<LanguagesEntity, Long> {

    @Query("SELECT c.name, l.language, l.percentage FROM LanguagesEntity l JOIN l.country c WHERE l.percentage > 89 ORDER BY l.percentage DESC")
    List<Object[]> getHighPercentLanguages();

}