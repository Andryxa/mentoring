package com.andryxa.mentoring.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ClientAccountEntityPK implements Serializable {
    private int clientId;
    private int accountId;

    @Column(name = "client_id")
    @Id
    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Column(name = "account_id")
    @Id
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientAccountEntityPK that = (ClientAccountEntityPK) o;

        if (clientId != that.clientId) return false;
        if (accountId != that.accountId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = clientId;
        result = 31 * result + accountId;
        return result;
    }
}
