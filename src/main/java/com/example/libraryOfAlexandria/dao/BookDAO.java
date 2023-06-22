package com.example.libraryOfAlexandria.dao;

import com.example.libraryOfAlexandria.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDAO extends JpaRepository<Book, Long> {
    public Book getBookByTitle(String title);
}
