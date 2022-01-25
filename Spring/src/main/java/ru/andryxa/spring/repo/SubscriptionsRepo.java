package ru.andryxa.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;
import ru.andryxa.spring.entity.Subscriptions;

@RestController
public interface SubscriptionsRepo extends JpaRepository<Subscriptions, Integer> {
}
