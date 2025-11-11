package org.example.booksapi.controller;


import org.example.booksapi.Model.Book;
import org.springframework.web.bind.annotation.*;
import org.example.booksapi.services.BookService;


@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @RequestMapping(value="/api/books/{id}", method= RequestMethod.GET)
    public Book update(
            @PathVariable("id") Long id,
            @RequestParam(value="title") String title,
            @RequestParam(value="description") String desc,
            @RequestParam(value="language") String lang,
            @RequestParam(value="pages") Integer numOfPages) {
        Book book = bookService.updateBook(id, title, desc, lang, numOfPages);
        return book;
    }

    @RequestMapping(value="/api/books", method= RequestMethod.GET)
    public Book create(){
        String title ="title1";
        String desc ="desc123123123";
        String lang ="lang22";
        Integer numOfPages= 1000;
        Book book = bookService.createBook(title, desc, lang, numOfPages);
        return book;
    }



    @RequestMapping(value="/api/delete/{id}", method=RequestMethod.GET)
    public void destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
    }
}




