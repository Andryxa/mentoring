package ru.andryxa.spring.mappers;

import ru.andryxa.spring.dto.BookDTO;
import ru.andryxa.spring.entity.Book;

public class BookMapper {
    private BookMapper() {}

    public static BookDTO getBookDTO(Book book) {
        return new BookDTO(book.getId(), book.getName(), book.getAuthor(), book.getCount());
    }

    public static Book getBook(BookDTO bookDTO) {
        return new Book(bookDTO.getName(), bookDTO.getAuthor(), bookDTO.getCount());
    }
}
