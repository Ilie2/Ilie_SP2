package com.example.ilie_sp2.Book;

import java.util.List;

public class Section implements Element{
    private final String title;
    private List<Element> elements;
    public Section(String title) {
        this.title = title;
    }
    @Override
    public void print() {
        System.out.println(title);
        for (Element element : elements) {
            element.print();
        }
    }

    @Override
    public void add(Element element) {
        elements.add(element);
    }

    @Override
    public void remove(Element element) {
        elements.remove(element);
    }

    @Override
    public Element get(int index) {
        return elements.get(index);
    }
}
