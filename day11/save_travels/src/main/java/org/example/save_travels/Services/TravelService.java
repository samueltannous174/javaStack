package org.example.save_travels.Services;

import org.example.save_travels.Models.Travel;
import org.example.save_travels.Repositieres.TravelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TravelService {
    private final TravelRepository travelRepository;

    public TravelService(TravelRepository travelRepository) {
        this.travelRepository = travelRepository;
    }

    public Travel createTravel(Travel travel){
      return travelRepository.save(travel);
    }
    public List<Travel> getAll(){
        return (List<Travel>) travelRepository.findAll();
    }

    public Travel findTravel(Long id){
        Optional optional = travelRepository.findById(id);
        if(optional.isPresent()){
            return (Travel) optional.get();
        }
        return null;
    }
    public List<Travel> findTravelByExpense(String expense){
        List<Travel>  travels= travelRepository.findByExpense(expense);

        return travels;
    }
    public void deleteTravel(Long id){
        travelRepository.deleteById(id);
    }

    public Travel edit(Travel newTravel){
        Optional optional = travelRepository.findById(newTravel.getId());
        if(optional.isPresent()){
            Travel travel =(Travel) optional.get();
            travel.setVendor(newTravel.getVendor());
            travel.setExpense(newTravel.getExpense());
            travel.setDescription(newTravel.getDescription());
            travel.setAmount(newTravel.getAmount());
            travelRepository.save(travel);
            return travel;
        }
        return null;
    }



}