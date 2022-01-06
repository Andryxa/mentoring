package ru.andryxa.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.andryxa.spring.DTO.BookDTO;
import ru.andryxa.spring.entity.Book;
import ru.andryxa.spring.repo.BookRepo;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookService {

    private final BookRepo bookRepo;

    @Autowired
    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public BookDTO getBookDTO(Book book) {
        BookDTO bookDTO = new BookDTO(book.getId(), book.getName(),
                book.getAuthor(), book.getCount());
        return bookDTO;
    }

    public Book getBook(BookDTO bookDTO) {
        Book book = new Book(bookDTO.getId(), bookDTO.getName(),
                bookDTO.getAuthor(), bookDTO.getCount());
        return book;
    }

    public List<BookDTO> getListOfBooks() {
        List<BookDTO> bookDTOList = new ArrayList<>();
        List<Book> bookList = bookRepo.findAll();
        for (Book book : bookList) {
            bookDTOList.add(getBookDTO(book));
        }
        return bookDTOList;
    }

    public BookDTO save(BookDTO bookDTO) {
        bookRepo.save(getBook(bookDTO));
        return bookDTO;
    }

    public void deleteBook(int id) {
        bookRepo.deleteById(id);
    }

}
