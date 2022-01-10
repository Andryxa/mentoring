package ru.andryxa.spring.DTO;


public class SubscriptionDTO {
    private int id;
    private UserDTO userIdDTO;
    private BookDTO bookIdDTO;

    public SubscriptionDTO(int id, UserDTO userIdDTO, BookDTO bookIdDTO) {
        this.id = id;
        this.userIdDTO = userIdDTO;
        this.bookIdDTO = bookIdDTO;
    }

    public SubscriptionDTO() {
    }

    public int getIdDTO() {
        return id;
    }

    public void setIdDTO(int id) {
        this.id = id;
    }

    public UserDTO getUserIdDTO() {
        return userIdDTO;
    }

    public void setUserIdDTO(UserDTO userIdDTO) {
        this.userIdDTO = userIdDTO;
    }

    public BookDTO getBookIdDTO() {
        return bookIdDTO;
    }

    public void setBookIdDTO(BookDTO bookIdDTO) {
        this.bookIdDTO = bookIdDTO;
    }
}
