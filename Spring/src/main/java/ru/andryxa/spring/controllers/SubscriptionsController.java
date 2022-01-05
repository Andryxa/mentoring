package ru.andryxa.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.andryxa.spring.entity.Book;
import ru.andryxa.spring.entity.Subscriptions;
import ru.andryxa.spring.entity.User;
import ru.andryxa.spring.repo.SubscriptionsRepo;


@RestController
public class SubscriptionsController {
    private final SubscriptionsRepo subRepo;

    @Autowired
    public SubscriptionsController(SubscriptionsRepo subRepo) {
        this.subRepo = subRepo;

    }

    @GetMapping("/subscriptions")
    public Iterable<Subscriptions> subscriptions() {
        return subRepo.findAll();
    }

    @PostMapping("/newSubscription")
    public String newSubscription(@RequestParam("userId") User userId,
                                  @RequestParam("bookId") Book bookId) {
        Subscriptions subscription = new Subscriptions();
        subscription.setUserId(userId);
        subscription.setBookId(bookId);

        subRepo.save(subscription);
        return "Add new subscription";
    }

    @DeleteMapping("/deleteSubscription")
    private String delete(@RequestParam("id") int id) {
        subRepo.deleteById(id);
        return "Delete done!";
    }

    @PostMapping("/updateSubscription")
    private String update(@RequestParam("id") int id,
                          @RequestParam("userId") User userId,
                          @RequestParam("bookId") Book bookId) {
        Subscriptions subscription = subRepo.findById(id);
        subscription.setUserId(userId);
        subscription.setBookId(bookId);
        subRepo.save(subscription);
        return "Update done!";
    }
}
