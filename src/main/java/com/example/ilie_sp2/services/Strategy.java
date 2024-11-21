package com.example.ilie_sp2.services;

import com.example.ilie_sp2.Book.Paragraph;

public interface Strategy {
    public default void render(Paragraph paragraph, int width){}
}

