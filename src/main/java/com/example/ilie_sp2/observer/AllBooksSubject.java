package com.example.ilie_sp2.observer;

import com.example.ilie_sp2.Book.Book;
import com.example.ilie_sp2.repos.BooksRepository;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Component
public class AllBooksSubject {

    private final List<Observer> observers = new ArrayList<>();
    private final BooksRepository booksRepository;

    public AllBooksSubject(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers(Book book) {
        for (Observer observer : observers) {
            observer.update(book);
        }
    }

    public List<Book> getAllBooks() {
        return booksRepository.findAll(); // Obține toate cărțile din baza de date
    }

    public Book getBookById(Integer id) {
        return booksRepository.findById(id).orElse(null); // Obține o carte după ID
    }

}
