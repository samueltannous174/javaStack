package org.example.booksapi.controller;

import org.example.booksapi.Model.Book;
import org.example.booksapi.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BookController3 {
    private final BookService bookService;

    public BookController3(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/books")
    public String index(Model model) {
        List<Book> books = bookService.allBooks();
        System.out.println(books);
        model.addAttribute("books", books);
        return "/books/index2";
    }
}