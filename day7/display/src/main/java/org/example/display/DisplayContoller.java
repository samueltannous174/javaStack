package org.example.display;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller

public class DisplayContoller {
    @RequestMapping("/")
    public String display(){
        return "index.jsp";
    }
    @RequestMapping("/time")
    public String time(Model model){
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        String formattedDate = dateFormat.format(now);
        model.addAttribute("time",formattedDate);

        return "time.jsp";
    }
    @RequestMapping("/date")
    public String date(Model model){
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd ");
        String formattedDate = dateFormat.format(now);
        model.addAttribute("date",formattedDate);

        return "date.jsp";
    }

}
