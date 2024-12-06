package com.example.ilie_sp2.Book;

public interface Element {
    void print();
    void add(Element element);
    void remove(Element element);
    Element get(int index);
}
