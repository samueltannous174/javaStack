package org.example.ninja;


import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Random;
import java.time.LocalDateTime;




@Controller
public class NinjaController {
    @GetMapping
    public  String index(HttpSession session){
        if (session.getAttribute("gold") == null){
            session.setAttribute("gold",0);
        }

        return "index.jsp";
    }
    @PostMapping("/submit")
    public  String submit(@RequestParam(value = "type") String type, HttpSession session) {
        Integer gold = (Integer) session.getAttribute("gold");
        if (session.getAttribute("info") == null) {
            ArrayList<String> info = new ArrayList<>();
            session.setAttribute("info", info);
        }
        ArrayList<String> info = (ArrayList<String>) session.getAttribute("info");
        LocalDateTime currentDateTime = LocalDateTime.now();


        session.getAttribute("gold");
        Random rand = new Random();
        System.out.println(gold);


        int min;
        int max;
        int randomNumber;

        switch (type){
            case "Farm":
                min = 10;
                 max = 20;
                 randomNumber = (int)(Math.random() * ((max - min) + 1)) + min;
                 gold += randomNumber;
                 session.setAttribute("gold",gold);
                System.out.println(gold);
                info.add("earned a farm "+ randomNumber+ " " + currentDateTime);
                break;


            case "Cave":
                min = 5;
                max = 10;
                randomNumber = (int)(Math.random() * ((max - min) + 1)) + min;
                gold += randomNumber;
                session.setAttribute("gold",gold);
                info.add("earned a cave "+ randomNumber+ " " + currentDateTime);
                break;


            case "House":
                min = 2;
                max = 5;
                randomNumber = (int)(Math.random() * ((max - min) + 1)) + min;
                gold += randomNumber;
                session.setAttribute("gold",gold);
                info.add("earned a house "+ randomNumber+ " " + currentDateTime);
                break;


            case "Quest":
                min = 0;
                max = 50;
                randomNumber = (int)(Math.random() * ((max - min) + 1)) + min;
                if (randomNumber%2 == 0){
                    gold+=randomNumber;
                    info.add("completed a quest earned"+ randomNumber + " " + currentDateTime);
                }else {
                    gold-=randomNumber;
                    info.add("failed a quest taken"+ randomNumber + " " + currentDateTime);
                }
                session.setAttribute("gold",gold);
                break;
        }

        return "redirect:/";
    }
}
