package com.example.ilie_sp2.difexample;

import com.example.ilie_sp2.Book.Book;
import com.example.ilie_sp2.services.BookService;
import com.example.ilie_sp2.repos.BooksRepository;
import com.example.ilie_sp2.observer.AllBooksSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final BookService bookService;
    private final AllBooksSubject allBooksSubject;

    @Autowired
    private BooksRepository booksRepository;

    @Autowired
    public BooksController(BookService bookService, AllBooksSubject allBooksSubject) {
        this.bookService = bookService;
        this.allBooksSubject = allBooksSubject; // Spring will inject this automatically
    }

    @PostMapping("/new")
    public ResponseEntity<Book> addBook(@RequestBody Book newBook) {
        // Add the book to the database
        booksRepository.save(newBook);

        // Notify all connected clients (SSE observers) about the new book
        allBooksSubject.addBook(newBook); // This will notify all SSE observers about the new book
        return ResponseEntity.ok(newBook);
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        return booksRepository.getReferenceById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Integer id) {
        booksRepository.deleteById(id);
    }

    @GetMapping("/all")
    public List<Book> getAllBooks() {
        return booksRepository.findAll();
    }
}
