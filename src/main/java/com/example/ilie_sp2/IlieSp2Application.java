package com.example.ilie_sp2;

import com.example.ilie_sp2.difexample.ClientComponent;
import com.example.ilie_sp2.difexample.SingletonComponent;
import com.example.ilie_sp2.difexample.TransientComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class IlieSp2Application {
    public static void main(String[] args) {
        SpringApplication.run(IlieSp2Application.class, args);
    }
}