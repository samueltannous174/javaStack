package org.example.burger1.Services;


import org.example.burger1.Models.Burger;
import org.example.burger1.Repositories.BurgerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.awt.print.Book;
import java.util.List;

@Service
public class BurgerService {
    private final BurgerRepository burgerRepository;

    public BurgerService(BurgerRepository burgerRepository) {
        this.burgerRepository = burgerRepository;
    }

    public Burger createBurger(Burger newBurger){
        Burger burger =  new Burger(newBurger.getBurgerName(), newBurger.getRestaurantName(), newBurger.getRating(), newBurger.getNotes());
        return burgerRepository.save(burger);
    }
    public Burger find(Long id){
        Optional <Burger> burger= burgerRepository.findById(id);
        if(burger.isPresent()){
            return burger.get();
        }
        return null;

    }
    public List<Burger> getAllBurgers(){
        return (List<Burger>) burgerRepository.findAll();
    }
    public Burger edit(Long id, Burger newBurger){
        Optional <Burger> burger= burgerRepository.findById(id);
        if(burger.isPresent()){
            Burger burger1 = burger.get();
            burger1.setBurgerName(newBurger.getBurgerName());
            burger1.setRestaurantName(newBurger.getRestaurantName());
            burger1.setRating(newBurger.getRating());
            burger1.setNotes(newBurger.getNotes());

            System.out.println(burger1.getBurgerName());
            burgerRepository.save(burger.get());

            return burger.get();
        }
        return null;
    }

}
