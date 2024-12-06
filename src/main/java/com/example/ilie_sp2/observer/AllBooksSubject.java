package com.example.ilie_sp2.observer;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import com.example.ilie_sp2.Book.Book;

@Component
public class AllBooksSubject {

    private final List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers(Book book) {
        for (Observer observer : observers) {
            observer.update(book);
        }
    }
}
