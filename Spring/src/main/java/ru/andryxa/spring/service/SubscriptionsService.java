package ru.andryxa.spring.service;

import ru.andryxa.spring.dto.SubscriptionDTO;

import java.util.List;

public interface SubscriptionsService {

    List<SubscriptionDTO> subscriptionsList();

    SubscriptionDTO createSub(SubscriptionDTO subscriptionDTO);

    SubscriptionDTO updateSub(SubscriptionDTO subscriptionDTO);

    void delete(int id);
}
