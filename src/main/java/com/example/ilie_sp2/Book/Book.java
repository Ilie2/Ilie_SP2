package com.example.ilie_sp2.Book;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private List<Element> elements=new ArrayList<>();
    private List<Author> authors=new ArrayList<>();
    public Book(String title) {
        this.title=title;
    }
    public void addElement(Element element) {
        elements.add(element);
    }
    public void addAuthor(Author author) {
        authors.add(author);
    }
    public void print() {
        System.out.println("Title: "+title);
        System.out.println("Authors: ");
        for (Author author : authors) {
            author.print();
        }
        System.out.println("Content: "+elements);
        for (Element element : elements) {
            element.print();
        }
    }

    public void addContent(Paragraph paragraph) {
        paragraph.print();
    }

    public void addContent(Section cap1) {
        cap1.print();
    }
}
