package org.example.booksapi.services;


import org.example.booksapi.Model.Book;
import org.springframework.stereotype.Service;
import org.example.booksapi.repositers.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> allBooks() {
        return bookRepository.findAll();
    }

    public void deleteBook(long id){
          bookRepository.deleteById(id);

    }
    public Book book(long id){
       Optional<Book> book= bookRepository.findById(id);
       if (book.isPresent()){
           return book.get();
       }
         return null;


    }

    public Book createBook(String title, String desc, String lang, Integer numOfPages) {
        Book b = new Book(title,desc,lang,numOfPages);
        return bookRepository.save(b);
    }

    public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            System.out.println(book);
            book.setTitle("new title");
            book.setDescription("aksjdjaskhdkasd");
            book.setLanguage("english");
            return bookRepository.save(book);

        } else {
            return null;
        }
    }

}
