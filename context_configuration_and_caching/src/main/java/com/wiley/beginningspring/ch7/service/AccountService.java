package com.wiley.beginningspring.ch7.service;


import com.wiley.beginningspring.ch7.model.Account;

public interface AccountService {
    public void transferMoney(
            long sourceAccountId, long targetAccountId, double amount);

    public void depositMoney(long accountId, double amount) throws Exception;

    public Account getAccount(long accountId);
}
