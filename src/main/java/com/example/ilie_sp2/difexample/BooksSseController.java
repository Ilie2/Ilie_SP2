//package com.example.ilie_sp2.difexample;
//
//import com.example.ilie_sp2.Book.Book;
//import com.example.ilie_sp2.observer.Observer;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
//import com.example.ilie_sp2.observer.AllBooksSubject;
//import com.example.ilie_sp2.observer.SseObserver;
//
//import java.util.concurrent.Executors;
//import java.util.concurrent.TimeUnit;
//
//@RestController
//public class BooksSseController {
//
//    private final AllBooksSubject allBooksSubject;
//
//    public BooksSseController(AllBooksSubject allBooksSubject) {
//        this.allBooksSubject = allBooksSubject;
//    }
//
//    @GetMapping("/books-sse")
//    public SseEmitter getBooksSse() {
//        SseEmitter emitter = new SseEmitter(Long.MAX_VALUE);
//        allBooksSubject.attach((Observer) new SseObserver(emitter));
//
//        // Exemplu de emitere a listei de cărți
//        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> {
//            try {
//                // Obținem lista de cărți
//                var books = allBooksSubject.getAllBooks();
//
//                // Forțăm încărcarea colecțiilor lazy (dacă există) pentru fiecare carte
//                books.forEach(book -> {
//                    if (book.getElements() != null) {
//                        book.getElements().size(); // Forțează încărcarea colecției elements
//                    }
//                });
//
//                // Trimitem datele prin SSE
//                emitter.send(SseEmitter.event().data(books));
//            } catch (Exception e) {
//                emitter.completeWithError(e);
//            }
//        }, 0, 5, TimeUnit.SECONDS);
//
//        emitter.onCompletion(() -> allBooksSubject.attach(null));
//        emitter.onTimeout(emitter::complete);
//        emitter.onError(emitter::completeWithError);
//
//        return emitter;
//    }
//
//    @GetMapping("/books-sse/{id}")
//    public SseEmitter getBookById(@PathVariable String id) {
//        SseEmitter emitter = new SseEmitter();
//        try {
//            // Presupunem că există o metodă pentru a găsi o carte după ID
//            Book book = allBooksSubject.getBookById(Integer.valueOf(id));
//
//            // Forțăm încărcarea colecției lazy (dacă există) pentru această carte
//            if (book instanceof Book) {
//                Book bookEntity = book;
//                if (bookEntity.getElements() != null) {
//                    bookEntity.getElements().size(); // Forțează încărcarea colecției elements
//                }
//            }
//
//            // Trimitem cartea găsită prin SSE
//            if (book != null) {
//                emitter.send(SseEmitter.event().data(book));
//            } else {
//                emitter.send(SseEmitter.event().data("Cartea cu ID-ul " + id + " nu a fost găsită."));
//            }
//            emitter.complete();
//        } catch (Exception e) {
//            emitter.completeWithError(e);
//        }
//        return emitter;
//    }
//}
