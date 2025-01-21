package com.example.ilie_sp2.difexample;
import com.example.ilie_sp2.Book.Book;
import com.example.ilie_sp2.services.BookService;
import com.example.ilie_sp2.services.Command;
import com.example.ilie_sp2.services.CommandInvoker;
import com.example.ilie_sp2.services.GetBookByIdCommand;
import com.example.ilie_sp2.observer.AllBooksSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import com.example.ilie_sp2.repos.BooksRepository;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final BookService bookService;
    private final CommandInvoker commandInvoker;

    @Autowired
    public BooksController(BookService bookService) {
        this.bookService = bookService;
        this.commandInvoker = new CommandInvoker();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
//        Command command = new GetBookByIdCommand(bookService, id);
//        commandInvoker.addCommand(command);
//        commandInvoker.executeCommands();
        return booksRepository.getReferenceById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Integer id) {
        booksRepository.deleteById(id);
    }


    @Autowired
    private BooksRepository booksRepository;

    private AllBooksSubject allBooksSubject;

    @PostMapping("/new")
    public String newBook(@RequestBody Book newBookRequest) {
        Book book = booksRepository.save(newBookRequest);
        allBooksSubject.notifyObservers(book);
        return "Book saved [" + book.getId() + "] " + book.getTitle();
    }
    @GetMapping("/all")
    public List<Book> getAllBooks() {
        return booksRepository.findAll();
    }
}
