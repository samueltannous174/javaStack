package org.example.burger1.Repositories;


import org.example.burger1.Models.Burger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BurgerRepository  extends CrudRepository<Burger, Long> {

}
