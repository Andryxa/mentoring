package ru.andryxa.spring.dto;


public class SubscriptionDTO {
    private int id;
    private UserDTO userId;
    private BookDTO bookId;

    public SubscriptionDTO(int id, UserDTO userId, BookDTO bookId) {
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

    public UserDTO getUserId() {
        return userId;
    }

    public BookDTO getBookId() {
        return bookId;
    }

    public void setUserId(UserDTO userId) {
        this.userId = userId;
    }

    public void setBookId(BookDTO bookId) {
        this.bookId = bookId;
    }
}
