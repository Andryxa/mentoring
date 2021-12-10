package com.andryxa.mentoring.dao;


import com.andryxa.mentoring.entity.Account;

import java.util.List;

public interface AccountFunctional {
    void addAccount(String name, String password, int ownerId);

    void deleteAccount(int id);

    void update(int id, String name, String password);

    List<Account> allAccounts();

}
