package org.example.pathvariables;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TravelController{
    @RequestMapping("/daikichi/travel/{city}")
    public String index(@PathVariable("city") int city){
        return "Congrats You will travel to"+ city;
    }
    @RequestMapping("/daikichi/lotto/{number}")
    public String index2(@PathVariable("number") int number){
        if (number%2 == 0){
            return "You will take a grand journey in the near future but be wary of tempting offers";
        }else{
            return  "You have enjoyed the fruits of your labor, but now is a great time to spend time with family and friends.";
        }
    }
}
