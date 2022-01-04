package ru.andryxa.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.andryxa.spring.entity.Books;
import ru.andryxa.spring.repo.BooksRepo;

@RestController
public class BooksController {

    private final BooksRepo booksRepo;

    @Autowired
    public BooksController(BooksRepo booksRepo) {
        this.booksRepo = booksRepo;
    }

    @GetMapping("/books")
    public Iterable<Books> showBooks() {
        return booksRepo.findAll();
    }

    @PostMapping("/createBook")
    public String newBook(@RequestParam("name") String name,
                          @RequestParam("author") String author,
                          @RequestParam("count") int count) {
        Books book = new Books();
        book.setName(name);
        book.setAuthor(author);
        book.setCount(count);
        booksRepo.save(book);
        return "Book added";
    }

    @PostMapping("/updateBook")
    public String updateBook(@RequestParam("id") int id,
                             @RequestParam("name") String name,
                             @RequestParam("author") String author,
                             @RequestParam("count") int count) {
        Books book = booksRepo.findById(id);
        book.setName(name);
        book.setAuthor(author);
        book.setCount(count);
        booksRepo.save(book);
        return "Updated!";
    }

    @DeleteMapping("/deleteBook")
    public String deleteBook(@RequestParam("id") int id) {
        booksRepo.deleteById(id);
        return "deleted!";
    }
}
