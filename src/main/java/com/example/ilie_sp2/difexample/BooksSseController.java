package com.example.ilie_sp2.difexample;

import com.example.ilie_sp2.observer.Observer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import com.example.ilie_sp2.observer.AllBooksSubject;
import com.example.ilie_sp2.observer.SseObserver;

@RestController
public class BooksSseController {

    private final AllBooksSubject allBooksSubject;

    public BooksSseController(AllBooksSubject allBooksSubject) {
        this.allBooksSubject = allBooksSubject;
    }

    @GetMapping("/books-sse")
    public SseEmitter getBooksSse() {
        SseEmitter emitter = new SseEmitter(Long.MAX_VALUE);
        allBooksSubject.attach((Observer) new SseObserver(emitter));
        return emitter;
    }
}
