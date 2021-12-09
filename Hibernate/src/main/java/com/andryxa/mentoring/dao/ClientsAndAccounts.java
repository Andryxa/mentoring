package com.andryxa.mentoring.dao;

import com.andryxa.mentoring.entity.Account;
import com.andryxa.mentoring.entity.Client;

import java.util.List;

public interface ClientsAndAccounts {
    List<Account> getAllAccounts();

    List<Client> getAllClients();

}
