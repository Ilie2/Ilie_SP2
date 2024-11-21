package com.example.ilie_sp2.Book;

public class Author {
    private String name;
    private String surname;

    public Author(String name) {
        this.name = name;
        this.surname = surname;
    }
    public void print(){
        System.out.println(name + " " + surname);
    }
}
