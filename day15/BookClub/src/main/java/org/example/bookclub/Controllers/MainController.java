package org.example.bookclub.Controllers;


import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.example.bookclub.Models.Book;
import org.example.bookclub.Models.LoginUser;
import org.example.bookclub.Models.User;
import org.example.bookclub.Services.BookService;
import org.example.bookclub.Services.UserService;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {

    private final UserService userService;
    private final BookService bookService;


    public MainController(UserService userService, BookService bookService) {
        this.userService = userService;
        this.bookService = bookService;
    }



    @RequestMapping ("/**")
    public String Error404(@ModelAttribute("newUser") User newUser, @ModelAttribute("user") LoginUser user){
        return "error404";
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
    }

    @GetMapping("/")
    public String showBooks(Model model, HttpSession session){
        Long loggedId = (Long) session.getAttribute("id");

        if (loggedId == null){
            return "redirect:/auth";
        }
        User logged = userService.findUser(loggedId);
        model.addAttribute("logged",logged);


        List <Book> books= bookService.getAll();
        model.addAttribute("books", books);

        return "home";
    }


    @GetMapping("/show_create_book")
    public String createBook(@ModelAttribute ("book") Book book, HttpSession session, Model model){
        Long loggedId = (Long) session.getAttribute("id");

        if (loggedId == null){
            return "redirect:/auth";
        }
        User logged = userService.findUser(loggedId);
        model.addAttribute("logged",logged);


        return "createBook";
    }

    @PostMapping("/create_book")
    public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result, @RequestParam("user_id") Long user_id, HttpSession session , Model model){
        Long loggedId = (Long) session.getAttribute("id");

        if (loggedId == null){
            return "redirect:/auth";
        }
        User logged = userService.findUser(loggedId);
        model.addAttribute("logged",logged);

        if (result.hasErrors()){
            return "createBook";
        }

        Book createdBook = bookService.createBook(book);
        User loggedUser= userService.findUser(user_id);
        createdBook.setUser(loggedUser);
        bookService.save(createdBook);

        return "redirect:/";
    }

    @GetMapping("books/{id}")
    public String showBook(@PathVariable("id") Long id,Model model ,HttpSession session){
        if (session.getAttribute("id") == null){
            return "redirect:/auth";
        }

        Long loggedId = (Long) session.getAttribute("id");
        User logged = userService.findUser(loggedId);
        model.addAttribute("logged",logged);


        Book book = bookService.findBook(id);

        if (book == null){
            return "redirect:/";
        }
        model.addAttribute("book",book);
        return "showBook";

    }

    @GetMapping("/show_edit_book/{id}")
    public String showEditBook( @PathVariable("id") Long id,Model model, HttpSession session){
        Long loggedId = (Long) session.getAttribute("id");

        if (loggedId == null){
            return "redirect:/auth";
        }
        User logged = userService.findUser(loggedId);
        model.addAttribute("logged",logged);

        Book book = bookService.findBook(id);

        if (book == null){
            return "redirect:/";
        }

        if (book.getUser().getId() != loggedId){
            return "redirect:/";
        }

        model.addAttribute("book",book);

        return "editBook";
    }

    @PutMapping ("/edit_book")
    public String editBook(@Valid @ModelAttribute ("book") Book book , BindingResult result , HttpSession session, Model model){

        Long loggedId = (Long) session.getAttribute("id");

        if (loggedId == null){
            return "redirect:/auth";
        }


        if (result.hasErrors()){
            return "editBook";
        }

        bookService.save(book);

        return "redirect:/";
    }

    @DeleteMapping("delete_book")
    public String deleteBook(HttpSession session, Model model, @RequestParam("id") Long id){
        Long loggedId = (Long) session.getAttribute("id");

        if (loggedId == null){
            return "redirect:/auth";
        }

         bookService.deleteBook(id);

        return "redirect:/";
    }


}
