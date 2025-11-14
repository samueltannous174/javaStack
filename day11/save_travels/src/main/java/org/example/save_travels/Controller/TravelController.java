package org.example.save_travels.Controller;
import jakarta.validation.Valid;
import org.example.save_travels.Models.Travel;
import org.example.save_travels.Services.TravelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.apache.logging.log4j.util.LambdaUtil.getAll;

@Controller
public class TravelController {
    private final TravelService travelService;

    public TravelController(TravelService travelService) {
        this.travelService = travelService;
    }

    @GetMapping("/")
    public String showAllTravels(@ModelAttribute("travel") Travel travel, Model model){
        List<Travel> travels= travelService.getAll();
        model.addAttribute("travels", travels);
        return "allTravels";

    }

    @GetMapping("/show_edit/{id}")
    public String showEdit(@PathVariable("id") Long id , Model model){
        Travel travel = travelService.findTravel(id);
        if (travel == null) {
            return "redirect:/";
        }
        model.addAttribute("travel",travel);
        return "editTravel";
    }
    @GetMapping("/expenses/{id}")
    public String showExpense(@PathVariable("id") Long id , Model model){
        Travel travel = travelService.findTravel(id);
        if (travel == null) {
            return "redirect:/";
        }
        model.addAttribute("travel",travel);
        return "showExpense";

    }

    @PostMapping("/create_travel")
    public String createTravel(@Valid @ModelAttribute("travel") Travel travel, BindingResult result, Model model){
        if (result.hasErrors()){
            List<Travel> travels= travelService.getAll();
            model.addAttribute("travels", travels);

            return "allTravels";
        }
        travelService.createTravel(travel);
        return "redirect:/";
    }

    @PutMapping (value="/edit_travel")
    public String editTravel(@Valid @ModelAttribute("travel") Travel travel, BindingResult result){
        if (result.hasErrors()){
            return "editTravel";
        }
        travelService.edit(travel);
        return "redirect:/";
    }
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        travelService.deleteTravel(id);
        return "redirect:/";
    }
}
