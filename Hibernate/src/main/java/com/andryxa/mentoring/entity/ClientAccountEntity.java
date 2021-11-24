package com.andryxa.mentoring.entity;

import javax.persistence.*;

@Entity
@Table(name = "client_account", schema = "accounts", catalog = "")
@IdClass(ClientAccountEntityPK.class)
public class ClientAccountEntity {
    private int clientId;
    private int accountId;

    @Id
    @Column(name = "client_id")
    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Id
    @Column(name = "account_id")
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

        ClientAccountEntity that = (ClientAccountEntity) o;

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
