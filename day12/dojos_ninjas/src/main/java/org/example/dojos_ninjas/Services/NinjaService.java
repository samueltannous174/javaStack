package org.example.dojos_ninjas.Services;

import org.example.dojos_ninjas.Models.Ninja;
import org.example.dojos_ninjas.Repositieres.NinjaRepository;
import org.springframework.stereotype.Service;


@Service
public class NinjaService {
    private final NinjaRepository  ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public void createNinja(Ninja ninja){
       Ninja ninja1= ninjaRepository.save(ninja);
        System.out.println(ninja1 );
        System.out.println(ninja1.getDojo());

    }



}
