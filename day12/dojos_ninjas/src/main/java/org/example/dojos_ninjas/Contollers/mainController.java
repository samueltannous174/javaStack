package org.example.dojos_ninjas.Contollers;


import jakarta.validation.Valid;
import org.example.dojos_ninjas.Models.Dojo;
import org.example.dojos_ninjas.Models.Ninja;
import org.example.dojos_ninjas.Services.DojoService;
import org.example.dojos_ninjas.Services.NinjaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class mainController {

    private final DojoService dojoService;
    private final NinjaService ninjaService;

    public mainController(DojoService dojoService, NinjaService ninjaService) {
        this.dojoService = dojoService;
        this.ninjaService = ninjaService;
    }


@GetMapping("/")
    public String showNewDojo(@ModelAttribute("dojo") Dojo dojo,Model model){
        return "newDojo";
    }
    @GetMapping("/new_ninja")
    public String showNewNinja(@ModelAttribute("ninja") Ninja ninja, Model model){
       List<Dojo> dojos= dojoService.getAll();
       model.addAttribute("dojos",dojos);
        System.out.println(dojos);
        return "newNinja";
    }

    @PostMapping("/create_dojo")
    public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result){
        if (result.hasErrors()){
            return "newDojo";
        }
                    dojoService.createDojo(dojo);
                    return "redirect:/" ;
    }

    @PostMapping("/create_ninja")
    public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result){
        if (result.hasErrors()){
            return "newNinja";
        }
        ninjaService.createNinja(ninja);

        return "redirect:/" ;
    }

    @GetMapping("dojos/{id}")
    public String showDojo(@PathVariable("id") Long id, Model model){
        Dojo dojo= dojoService.findDojo(id);

        model.addAttribute("dojo", dojo);
        return "showDojo";
    }



}
