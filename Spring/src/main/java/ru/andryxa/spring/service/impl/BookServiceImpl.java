package ru.andryxa.spring.service.impl;

import org.springframework.stereotype.Service;
import ru.andryxa.spring.dto.BookDTO;
import ru.andryxa.spring.entity.Book;
import ru.andryxa.spring.repo.BookRepo;
import ru.andryxa.spring.service.BookService;
import ru.andryxa.spring.mappers.BookMapper;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepo bookRepo;

    public BookServiceImpl(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public List<BookDTO> getListOfBooks() {
        return bookRepo.findAll().stream().map(BookMapper::getBookDTO).toList();
    }

    public BookDTO createBook(BookDTO bookDTO) {
        Book bookSaved = bookRepo.save(BookMapper.getBook(bookDTO));
        return BookMapper.getBookDTO(bookSaved);
    }

    public BookDTO update(BookDTO bookDTO) {
        Book book = bookRepo.findById(bookDTO.getId()).orElseThrow();
        book.setName(bookDTO.getName());
        book.setAuthor(bookDTO.getAuthor());
        book.setCount(bookDTO.getCount());
        return BookMapper.getBookDTO(bookRepo.save(book));
    }

    public void deleteBook(int id) {
        bookRepo.deleteById(id);
    }
}
