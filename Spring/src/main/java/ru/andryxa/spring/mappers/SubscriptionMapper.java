package ru.andryxa.spring.mappers;

import ru.andryxa.spring.DTO.SubscriptionDTO;
import ru.andryxa.spring.entity.Subscriptions;

public class SubscriptionMapper {


    public static SubscriptionDTO getSubDTO(Subscriptions subscriptions) {
        SubscriptionDTO subscriptionDTO = new SubscriptionDTO();
        subscriptionDTO.setId(subscriptions.getId());
        subscriptionDTO.setUserId(UserMapper.getUserDTO(subscriptions.getUserId()));
        subscriptionDTO.setBookId(BookMapper.getBookDTO(subscriptions.getBookId()));
        return subscriptionDTO;
    }

    public static Subscriptions getSub(SubscriptionDTO subscriptionDTO) {
        Subscriptions subscription = new Subscriptions();
        subscription.setId(subscriptionDTO.getId());
        subscription.setUserId(UserMapper.getUser(subscriptionDTO.getUserId()));
        subscription.setBookId(BookMapper.getBook(subscriptionDTO.getBookId()));
        return subscription;
    }
}
