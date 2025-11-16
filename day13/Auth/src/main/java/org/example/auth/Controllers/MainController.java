package org.example.auth.Controllers;


import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.example.auth.Models.LoginUser;
import org.example.auth.Models.User;
import org.example.auth.Services.UserService;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.naming.Binding;

@Controller
public class MainController {

    private final UserService userService;

    public MainController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showAuth(@ModelAttribute("newUser") User newUser, @ModelAttribute("user") LoginUser user){
        return "auth";
    }
    @RequestMapping("register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, @ModelAttribute("user") LoginUser user2){
        if (result.hasErrors()) {
            return "auth";
        }
        User user= userService.register(newUser,result);

        if (result.hasErrors()) {
            return "auth";
        }
        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("user") LoginUser user, BindingResult result, @ModelAttribute("newUser") User newUser, HttpSession session){
        if(result.hasErrors()){
            return "auth";
        }
        User loggedUser=userService.login(user, result);
        if(result.hasErrors()){
            return "auth";
        }
        if (session.getAttribute("id") == null){
            session.setAttribute("id", loggedUser.getId());
        }
        return "redirect:/";

    }
        @PostMapping("/logout")
    public String logout(HttpSession session){
        if (session != null) {
            session.invalidate();
        }

        return "redirect:/";

    }
}
