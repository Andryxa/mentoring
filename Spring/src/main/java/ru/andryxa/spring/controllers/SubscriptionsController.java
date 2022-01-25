package ru.andryxa.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.andryxa.spring.dto.SubscriptionDTO;
import ru.andryxa.spring.service.impl.SubscriptionsServiceImpl;

import java.util.List;


@RestController
public class SubscriptionsController {
    private final SubscriptionsServiceImpl subscriptionsService;

    @Autowired
    public SubscriptionsController(SubscriptionsServiceImpl subscriptionsService) {
        this.subscriptionsService = subscriptionsService;

    }

    @GetMapping("/subscriptions")
    public List<SubscriptionDTO> subscriptions() {
        return subscriptionsService.subscriptionsList();
    }

    @PostMapping("/createSubscription")
    public SubscriptionDTO createSubscription(@RequestBody SubscriptionDTO subscriptionDTO) {
        return subscriptionsService.createSub(subscriptionDTO);
    }

    @PutMapping("/updateSubscription")
    private SubscriptionDTO updateSubscription(@RequestBody SubscriptionDTO subscriptionDTO) {
        return subscriptionsService.updateSub(subscriptionDTO);
    }

    @DeleteMapping("/deleteSubscription")
    private String delete(@RequestParam("id") int id) {
        subscriptionsService.delete(id);
        return "Subscription with id=" + id + " has been deleted!";
    }
}
