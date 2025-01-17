package com.example.ilie_sp2.repos;

import com.example.ilie_sp2.Book.BaseElement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseElementRepos extends JpaRepository<BaseElement, Integer> {
}