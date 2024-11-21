package com.example.ilie_sp2.Book;

import com.example.ilie_sp2.services.AlignRight;

public class Paragraph implements Element {
    private String text;

    public Paragraph(String text) {
        this.text = text;
    }
    @Override
    public void print() {
        System.out.println(text);
    }

    @Override
    public void add(Element element) {

    }

    @Override
    public void remove(Element element) {

    }

    @Override
    public Element get(int index) {
        return null;
    }

    public String getText(AlignRight alignRight) {
        return text;
    }


    public void render(int i) {
    }
}
