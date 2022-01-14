package ru.andryxa.spring.service.impl;

import org.springframework.stereotype.Service;
import ru.andryxa.spring.dto.SubscriptionDTO;
import ru.andryxa.spring.entity.Subscriptions;
import ru.andryxa.spring.repo.SubscriptionsRepo;
import ru.andryxa.spring.service.SubscriptionsService;
import ru.andryxa.spring.mappers.BookMapper;
import ru.andryxa.spring.mappers.SubscriptionMapper;
import ru.andryxa.spring.mappers.UserMapper;

import java.util.List;

@Service
public class SubscriptionsServiceImpl implements SubscriptionsService {
    private final SubscriptionsRepo subscriptionsRepo;

    public SubscriptionsServiceImpl(SubscriptionsRepo subscriptionsRepo) {
        this.subscriptionsRepo = subscriptionsRepo;
    }

    public List<SubscriptionDTO> subscriptionsList() {
        return subscriptionsRepo.findAll().stream().map(SubscriptionMapper::getSubDTO).toList();
    }

    public SubscriptionDTO createSub(SubscriptionDTO subscriptionDTO) {
        return SubscriptionMapper.getSubDTO(subscriptionsRepo.save(SubscriptionMapper.getSub(subscriptionDTO)));
    }

    public SubscriptionDTO updateSub(SubscriptionDTO subscriptionDTO) {
        Subscriptions subscription = subscriptionsRepo.findById(subscriptionDTO.getId()).orElseThrow();
        subscription.setUserId(UserMapper.getUser(subscriptionDTO.getUserId()));
        subscription.setBookId(BookMapper.getBook(subscriptionDTO.getBookId()));
        return SubscriptionMapper.getSubDTO(subscriptionsRepo.save(subscription));
    }

    public void delete(int id) {
        subscriptionsRepo.deleteById(id);
    }
}
