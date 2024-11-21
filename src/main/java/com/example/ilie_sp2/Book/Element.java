package com.example.ilie_sp2.Book;

import com.example.ilie_sp2.services.AlignLeft;

public interface Element {
    void print();
    void add(Element element);
    void remove(Element element);
    public Element get(int index);


}
