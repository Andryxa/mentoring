package ru.andryxa.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.andryxa.spring.dto.BookDTO;
import ru.andryxa.spring.service.BookService;


import java.util.List;

@RestController
public class BooksController {

    private final BookService bookService;

    @Autowired
    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<BookDTO> showBooks() {
        return bookService.getListOfBooks();
    }

    @PostMapping("/createBook")
    public BookDTO newBook(@RequestBody BookDTO bookDTO) {
        return bookService.createBook(bookDTO);
    }

    @PutMapping("/updateBook")
    public BookDTO updateBook(@RequestBody BookDTO bookDTO) {
        return bookService.update(bookDTO);
    }

    @DeleteMapping("/deleteBook")
    public String deleteBook(@RequestParam("id") int id) {
        bookService.deleteBook(id);
        return "Book with id=" + id + " has been deleted!";
    }
}
