package ru.andryxa.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.andryxa.spring.DTO.BookDTO;
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
    public BookDTO newBook(@RequestParam("name") String name,
                           @RequestParam("author") String author,
                           @RequestParam("count") int count) {
        BookDTO bookDTO = new BookDTO(0, name, author, count);
        bookService.save(bookDTO);
        return bookDTO;
    }

    @PutMapping("/updateBook")
    public BookDTO updateBook(@RequestParam("id") int id,
                             @RequestParam("name") String name,
                             @RequestParam("author") String author,
                             @RequestParam("count") int count) {
        BookDTO bookDTO = new BookDTO(id, name, author, count);
        bookService.save(bookDTO);
        return bookDTO;
    }

    @DeleteMapping("/deleteBook")
    public String deleteBook(@RequestParam("id") int id) {
        bookService.deleteBook(id);
        return "Book with id=" + id + " has been deleted!";
    }
}
