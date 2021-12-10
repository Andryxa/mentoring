package com.andryxa.mentoring.dao;

import com.andryxa.mentoring.entity.Client;

import java.util.List;

public interface ClientFunctional {
    void addClient(String name, String lastname);

    void deleteClient(int id);

    List<Client> allClients();
}
