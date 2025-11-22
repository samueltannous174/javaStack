package org.example.finaljava.Controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.example.finaljava.Models.LoginUser;
import org.example.finaljava.Models.User;
import org.example.finaljava.Services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class MainController {

    private  final UserService userService;

    public MainController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping ("/**")
    public String Error404(@ModelAttribute("newUser") User newUser, @ModelAttribute("user") LoginUser user){
        return "error404";
    }

    @RequestMapping ("/")
    public String showHome(@ModelAttribute("newUser") User newUser, @ModelAttribute("user") LoginUser user,HttpSession session,Model model){
        Long loggedId = (Long) session.getAttribute("id");

        if (loggedId == null){
            return "redirect:/auth";
        }

        User logged = userService.findUser(loggedId);
        model.addAttribute("logged",logged);

        return "home";
    }

    @GetMapping("/auth")
    public String showAuth(
            @ModelAttribute("newUser") User newUser,
            @ModelAttribute("user") LoginUser user,
            HttpSession session,
            Model model) {

        Long loggedId = (Long) session.getAttribute("id");

        if (loggedId != null) {
            return "redirect:/";
        }

        return "auth";
    }

    @PostMapping  ("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, @ModelAttribute("user") LoginUser user2, HttpSession session){
        Long loggedId = (Long) session.getAttribute("id");

        if (loggedId != null) {
            return "redirect:/";
        }

        if (result.hasErrors()) {
            return "auth";
        }
        User user= userService.register(newUser,result);

        if (result.hasErrors()) {
            return "auth";
        }

        if (session.getAttribute("id") == null){
            session.setAttribute("id", user.getId());
        }


        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("user") LoginUser user, BindingResult result, @ModelAttribute("newUser") User newUser, HttpSession session){
        Long loggedId = (Long) session.getAttribute("id");

        if (loggedId != null) {
            return "redirect:/";
        }

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
    }}
