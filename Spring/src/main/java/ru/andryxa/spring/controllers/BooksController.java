package ru.andryxa.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.andryxa.spring.entity.Book;
import ru.andryxa.spring.repo.BookRepo;

@RestController
public class BooksController {

    private final BookRepo bookRepo;

    @Autowired
    public BooksController(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @GetMapping("/books")
    public Iterable<Book> showBooks() {
        return bookRepo.findAll();
    }

    @PostMapping("/createBook")
    public String newBook(@RequestParam("name") String name,
                          @RequestParam("author") String author,
                          @RequestParam("count") int count) {
        Book book = new Book();
        book.setName(name);
        book.setAuthor(author);
        book.setCount(count);
        bookRepo.save(book);
        return "Book added";
    }

    @PostMapping("/updateBook")
    public String updateBook(@RequestParam("id") int id,
                             @RequestParam("name") String name,
                             @RequestParam("author") String author,
                             @RequestParam("count") int count) {
        Book book = bookRepo.findById(id);
        book.setName(name);
        book.setAuthor(author);
        book.setCount(count);
        bookRepo.save(book);
        return "Updated!";
    }

    @DeleteMapping("/deleteBook")
    public String deleteBook(@RequestParam("id") int id) {
        bookRepo.deleteById(id);
        return "deleted!";
    }
}
