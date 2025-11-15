package org.example.dojos_ninjas.Repositieres;


import org.example.dojos_ninjas.Models.Dojo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

    @Repository
public interface DojoRepository extends CrudRepository<Dojo,Long> {




}
