package org.example.bookclub.Services;


import org.example.bookclub.Models.Book;
import org.example.bookclub.Models.User;
import org.example.bookclub.Repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public List<Book> getAll(){
        return (List<Book>) bookRepository.findAll();
    }
    public void save(Book book){
        bookRepository.save(book);
    }

    public Book findBook(Long id){
        Optional optional = bookRepository.findById(id);
        if(optional.isPresent()){
            return (Book) optional.get();
        }
        return null;
    }

    public void deleteBook(Long id){
        Book book= findBook(id);
        if (book == null){
            return;
        }
        bookRepository.delete(book);
    }

    public Book createBook(Book travel){
        return bookRepository.save(travel);
    }
}
