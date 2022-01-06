package ru.andryxa.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.andryxa.spring.DTO.SubscriptionDTO;
import ru.andryxa.spring.entity.Book;
import ru.andryxa.spring.entity.User;
import ru.andryxa.spring.service.SubscriptionsService;

import java.util.List;


@RestController
public class SubscriptionsController {
    private final SubscriptionsService subscriptionsService;

    @Autowired
    public SubscriptionsController(SubscriptionsService subscriptionsService) {
        this.subscriptionsService = subscriptionsService;

    }

    @GetMapping("/subscriptions")
    public List<SubscriptionDTO> subscriptions() {
        return subscriptionsService.subscriptionsList();
    }

    @PostMapping("/newSubscription")
    public SubscriptionDTO newSubscription(@RequestParam("userId") User userId,
                                  @RequestParam("bookId") Book bookId) {
        SubscriptionDTO subscriptionDTO = new SubscriptionDTO(0, userId,bookId);

        subscriptionsService.save(subscriptionDTO);
        return subscriptionDTO;
    }

    @PostMapping("/updateSubscription")
    private SubscriptionDTO update(@RequestParam("id") int id,
                          @RequestParam("userId") User userId,
                          @RequestParam("bookId") Book bookId) {
        SubscriptionDTO subscriptionDTO = new SubscriptionDTO(id,userId,bookId);
        subscriptionsService.save(subscriptionDTO);
        return subscriptionDTO;
    }

    @DeleteMapping("/deleteSubscription")
    private String delete(@RequestParam("id") int id) {
        subscriptionsService.delete(id);
        return "Subscription with id=" + id + " has been deleted!";
    }
}
