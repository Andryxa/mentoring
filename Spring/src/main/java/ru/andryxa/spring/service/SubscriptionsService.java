package ru.andryxa.spring.service;

import org.springframework.stereotype.Service;
import ru.andryxa.spring.DTO.SubscriptionDTO;
import ru.andryxa.spring.entity.Subscriptions;
import ru.andryxa.spring.repo.SubscriptionsRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubscriptionsService {
    private final SubscriptionsRepo subscriptionsRepo;
    private final UserService userService;
    private final BookService bookService;


    public SubscriptionsService(SubscriptionsRepo subscriptionsRepo, UserService userService, BookService bookService) {
        this.subscriptionsRepo = subscriptionsRepo;
        this.userService = userService;
        this.bookService = bookService;
    }

    public SubscriptionDTO getSubDTO(Subscriptions subscriptions) {
        SubscriptionDTO subscriptionDTO = new SubscriptionDTO();
        subscriptionDTO.setIdDTO(subscriptions.getId());
        subscriptionDTO.setUserIdDTO(userService.getUserDTO(subscriptions.getUserId()));
        subscriptionDTO.setBookIdDTO(bookService.getBookDTO(subscriptions.getBookId()));
        return subscriptionDTO;
    }

    public Subscriptions getSub(SubscriptionDTO subscriptionDTO) {
        Subscriptions subscriptions = new Subscriptions();
        subscriptions.setId(subscriptionDTO.getIdDTO());
        subscriptions.setUserId(userService.getUser(subscriptionDTO.getUserIdDTO()));
        subscriptions.setBookId(bookService.getBook(subscriptionDTO.getBookIdDTO()));
        return subscriptions;
    }

    public List<SubscriptionDTO> subscriptionsList() {
        List<SubscriptionDTO> subscriptionDTOList = new ArrayList<>();
        List<Subscriptions> list = subscriptionsRepo.findAll();
        for (Subscriptions subscriptions : list) {
            subscriptionDTOList.add(getSubDTO(subscriptions));
        }
        return subscriptionDTOList;
    }

    public void save(SubscriptionDTO subscriptionDTO) {
        subscriptionsRepo.save(getSub(subscriptionDTO));
    }

    public void delete(int id){
        subscriptionsRepo.deleteById(id);
    }
}
