package org.example.omikuji;


import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class Omikuji {

    @GetMapping("/")
    public String showFrom(){

            return "index.jsp";
    }
    @PostMapping("/submit")
        public String submit(@RequestParam(value = "city") String city, @RequestParam(value = "person") String person,
                         @RequestParam(value="nice") String nice, @RequestParam(value="hobby") String hobby, HttpSession session){

        session.setAttribute("city",city);
        session.setAttribute("person",person);
        session.setAttribute("hobby",hobby);
        session.setAttribute("nice",nice);

        return "redirect:/show_result";
    }

    @GetMapping("/show_result")
    public String showResults(){

        return "result.jsp";
    }



}
