package org.example.counter;

import jakarta.servlet.http.HttpSession;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Counter {

    @RequestMapping("/counter")

    public String index(HttpSession session, Model model){
        if(session.getAttribute("counter")  == null){
            session.setAttribute("counter",0);
        }
        else {
            Integer counter = (Integer) session.getAttribute("counter");
            counter++;
            System.out.println(counter);
            session.setAttribute("counter",counter);
        }
        return "index.jsp";
    }

    @PostMapping("/reset")

    public String reset(HttpSession session, Model model){
        if(session.getAttribute("counter")  != null){
            session.setAttribute("counter",0);
        }
        return "index.jsp";
    }
}
