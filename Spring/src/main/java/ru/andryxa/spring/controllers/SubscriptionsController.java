package ru.andryxa.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.andryxa.spring.DTO.BookDTO;
import ru.andryxa.spring.DTO.SubscriptionDTO;
import ru.andryxa.spring.DTO.UserDTO;
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
    public SubscriptionDTO newSubscription(@RequestParam("userIdDTO") UserDTO userIdDTO,
                                  @RequestParam("bookIdDTO") BookDTO bookIdDTO) {
        SubscriptionDTO subscriptionDTO = new SubscriptionDTO(0, userIdDTO,bookIdDTO);
        System.out.println(subscriptionDTO);
        subscriptionsService.save(subscriptionDTO);
        return subscriptionDTO;
    }

    @PutMapping("/updateSubscription")
    private SubscriptionDTO update(@RequestParam("id") int id,
                          @RequestParam("userId") UserDTO userIdDTO,
                          @RequestParam("bookId") BookDTO bookIdDTO) {
        SubscriptionDTO subscriptionDTO = new SubscriptionDTO(id,userIdDTO,bookIdDTO);
        subscriptionsService.save(subscriptionDTO);
        return subscriptionDTO;
    }

    @DeleteMapping("/deleteSubscription")
    private String delete(@RequestParam("id") int id) {
        subscriptionsService.delete(id);
        return "Subscription with id=" + id + " has been deleted!";
    }
}
