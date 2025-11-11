package org.example.booksapi.controller;


import org.example.booksapi.Model.Book;
import org.example.booksapi.services.BookService;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController2 {
    private final BookService bookService;

    public BookController2(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value="/books/{id}", method= RequestMethod.GET)
    public String render(@PathVariable("id") Long id , Model model){
        System.out.println(
                "hello"
        );
        Book book = bookService.book(id);
        System.out.println(book.getTitle());
        model.addAttribute("book", book);

        return "books/index";
    }
}
