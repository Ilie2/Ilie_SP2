package com.example.ilie_sp2.Book;

import java.io.Serializable;

public class Image implements Element    {
    private String url;

    public Image(String url) {
        this.url = url;
    }
    @Override
    public void print() {
        System.out.println("Url :" + url);
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
}
