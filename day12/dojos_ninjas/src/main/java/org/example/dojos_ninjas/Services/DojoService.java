package org.example.dojos_ninjas.Services;

import org.example.dojos_ninjas.Models.Dojo;
import org.example.dojos_ninjas.Models.Ninja;
import org.example.dojos_ninjas.Repositieres.DojoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DojoService {
    private final DojoRepository dojoRepository;

    public DojoService(DojoRepository dojoRepository) {
        this.dojoRepository = dojoRepository;
    }

    public void createDojo(Dojo newDojo){
     dojoRepository.save(newDojo);
    }

    public List<Dojo> getAll(){
        return (List<Dojo>) dojoRepository.findAll();
    }

    public Dojo findDojo(Long id) {
        Optional optional = dojoRepository.findById(id);
        if (optional.isPresent()) {
            return (Dojo) optional.get();
        }
        return null;
    }
}
