package ru.andryxa.spring.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Subscriptions {
    public Subscriptions(User userId, Book bookId, Date date) {
        this.userId = userId;
        this.bookId = bookId;
    }

    public Subscriptions() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book bookId;


    public int getId() {
        return id;
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
