package org.example.routes;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class DaikchiController {
    @RequestMapping("")
    public String index(){
        return "Hello !";
    }
    @RequestMapping("/today")
    public String index2(){
        return "Welcome !";
    }
    @RequestMapping("/tomorrow")
    public String index3(){
        return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
    }

    }
