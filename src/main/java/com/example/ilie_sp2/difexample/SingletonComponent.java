package com.example.ilie_sp2.difexample;

import org.springframework.stereotype.Component;
@Component
public class SingletonComponent {
    public SingletonComponent() {
        System.out.println(
                "SingletonComponent::SingletonComponent = " + this);

    }
    public void operation() {
        System.out.println(
                "Invoked SingletonComponent::operation() on " + this);

    }
}