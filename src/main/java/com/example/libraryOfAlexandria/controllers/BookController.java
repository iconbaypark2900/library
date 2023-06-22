package com.example.libraryOfAlexandria.controllers;

import com.example.libraryOfAlexandria.models.Book;
import com.example.libraryOfAlexandria.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    private BookService bookService;

    @Autowired
    public BookController (BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("api/book")
    public List<Book> getAllBooks() {
        return this.bookService.getAllBooks();
    }

    @PostMapping("api/book")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Book createBook(@RequestBody Book book){
        return this.bookService.createBook(book);
    }

    @GetMapping("api/book/{id}")
    public Book getBookById(@PathVariable Long id){
        return this.bookService.getBookById(id);
    }

    @GetMapping("api/book/name")
    public Book getBookByTitle(@RequestParam("title") String title){
        return this.bookService.getBookByTitle(title);
    }
    @DeleteMapping("api/book/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Long id){
        this.bookService.deleteBook(id);
    }

    @PutMapping("api/book/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable Long id){
        return this.bookService.updateBook(book, id);
    }
}
