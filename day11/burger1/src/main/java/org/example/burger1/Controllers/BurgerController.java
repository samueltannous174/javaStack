package org.example.burger1.Controllers;


import jakarta.validation.Valid;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;
import org.example.burger1.Models.Burger;
import org.example.burger1.Services.BurgerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BurgerController {
    private final BurgerService burgerService;

    public BurgerController(BurgerService burgerService) {
        this.burgerService = burgerService;
    }
@GetMapping("/")
    public String showCreatePage(@ModelAttribute("burger") Burger burger, Model model) {
    List<Burger> burgers=burgerService.getAllBurgers();
    model.addAttribute("burgers", burgers);

        return "addBurger";
    }
    @GetMapping("/edit/{id}")
    public String showEditPage(@PathVariable("id") Long id,Model model ) {
        Burger burger =burgerService.find(id);
        model.addAttribute("burger", burger);

        return "edit";
    }

    @PostMapping("/create_burger")

    public String createBurger(@Valid  @ModelAttribute("burger") Burger burger, BindingResult result, Model model) {

        if (result.hasErrors()){
            List<Burger> burgers=burgerService.getAllBurgers();
            model.addAttribute("burgers", burgers);

            return "addBurger";
        }
            System.out.println("success");
            burgerService.createBurger(burger);
            return "redirect:/";

    }

    @RequestMapping(value="/edit_burger/{id}", method=RequestMethod.PUT)

    public String editBurger(@PathVariable("id") Long id, @Valid  @ModelAttribute("burger") Burger burger, BindingResult result) {

        if (result.hasErrors()){

            return "edit";
        }
        System.out.println("success");
        Burger edited = burgerService.edit(id,burger);
        return "redirect:/";

    }

}
