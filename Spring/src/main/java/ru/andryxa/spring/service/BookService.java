package ru.andryxa.spring.service;

import ru.andryxa.spring.dto.BookDTO;

import java.util.List;

public interface BookService {

    List<BookDTO> getListOfBooks();

    BookDTO createBook(BookDTO bookDTO);

    BookDTO update(BookDTO bookDTO);

    void deleteBook(int id);
}
