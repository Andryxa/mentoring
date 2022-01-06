package ru.andryxa.spring.DTO;

import ru.andryxa.spring.entity.Book;
import ru.andryxa.spring.entity.User;

public class SubscriptionDTO {
    private int id;
    private User userId;
    private Book bookId;

    public SubscriptionDTO(int id, User userId, Book bookId) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
    }

    public SubscriptionDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Book getBookId() {
        return bookId;
    }

    public void setBookId(Book bookId) {
        this.bookId = bookId;
    }
}
