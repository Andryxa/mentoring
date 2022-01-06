package ru.andryxa.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.andryxa.spring.DTO.SubscriptionDTO;
import ru.andryxa.spring.entity.Subscriptions;
import ru.andryxa.spring.repo.SubscriptionsRepo;

import java.util.ArrayList;
import java.util.List;

@Component
public class SubscriptionsService {
    private final SubscriptionsRepo subscriptionsRepo;

    @Autowired
    public SubscriptionsService(SubscriptionsRepo subscriptionsRepo) {
        this.subscriptionsRepo = subscriptionsRepo;
    }

    public SubscriptionDTO getSubDTO(Subscriptions subscriptions) {
        SubscriptionDTO subscriptionDTO = new SubscriptionDTO();
        subscriptionDTO.setId(subscriptions.getId());
        subscriptionDTO.setUserId(subscriptions.getUserId());
        subscriptionDTO.setBookId(subscriptions.getBookId());
        return subscriptionDTO;
    }

    public Subscriptions getSub(SubscriptionDTO subscriptionDTO) {
        Subscriptions subscriptions = new Subscriptions();
        subscriptions.setId(subscriptionDTO.getId());
        subscriptions.setUserId(subscriptionDTO.getUserId());
        subscriptions.setBookId(subscriptionDTO.getBookId());
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
