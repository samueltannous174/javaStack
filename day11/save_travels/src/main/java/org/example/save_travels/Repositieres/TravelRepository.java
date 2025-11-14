package org.example.save_travels.Repositieres;

import org.example.save_travels.Models.Travel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TravelRepository  extends CrudRepository<Travel,Long> {

    List<Travel> findByExpense(String expense);

}
