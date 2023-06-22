package com.example.libraryOfAlexandria.services;

import com.example.libraryOfAlexandria.dao.BookDAO;
import com.example.libraryOfAlexandria.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private BookDAO bookDAO;

    @Autowired
    public BookService(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public List<Book> getAllBooks() {
        return this.bookDAO.findAll();
    }

    public Book createBook(Book book) {
        return this.bookDAO.save(book);
    }

    public Book getBookById(Long id) {
        return this.bookDAO.findById(id).orElse(new Book());
    }

    public Book getBookByTitle(String title) {
        return this.bookDAO.getBookByTitle(title);
    }

    public void deleteBook(Long id) {
        this.bookDAO.deleteById(id);
    }

    public Book updateBook(Book book, Long id) {
        Book bookToUpdate = this.bookDAO.findById(id).orElse(null);

        if(bookToUpdate == null) {
            return new Book();
        }

        bookToUpdate.setPrice(book.getPrice());
        bookToUpdate.setQuantityInStock(book.getQuantityInStock());

        return this.bookDAO.save(bookToUpdate);
    }
}