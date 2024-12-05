package com.example.ilie_sp2.difexample;

import com.example.ilie_sp2.Book.Book;
import com.example.ilie_sp2.services.BookService;
import com.example.ilie_sp2.services.Command;
import com.example.ilie_sp2.services.CommandInvoker;
import com.example.ilie_sp2.services.GetBookByIdCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Book getBookById(@PathVariable String id) {
        Command command = new GetBookByIdCommand(bookService, id);
        commandInvoker.addCommand(command);
        commandInvoker.executeCommands();
        return bookService.getBookById(id).orElse(null);
    }

    @PostMapping
    public void createBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

    @PutMapping("/{id}")
    public void updateBook(@PathVariable String id, @RequestBody Book book) {
        bookService.updateBook(id, book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable String id) {
        bookService.deleteBook(id);
    }
}
