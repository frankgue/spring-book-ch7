package com.wiley.beginningspring.ch7.dao;


import com.wiley.beginningspring.ch7.model.Account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountDaoInMemoryImpl implements AccountDao {

    private Map<Long, Account> accountsMap = new HashMap<>();

    {
        Account account1 = new Account();
        account1.setId(1L);
        account1.setOwnerName("John");
        account1.setBalance(10.0);
        Account account2 = new Account();
        account2.setId(2L);
        account2.setOwnerName("Mary");
        account2.setBalance(20.0);
        accountsMap.put(account1.getId(), account1);
        accountsMap.put(account2.getId(), account2);
    }

    @Override
    public void insert(Account account) {
        accountsMap.put(account.getId(), account);
    }

    @Override
    public void update(Account account) {
        Account oldAccount = find(account.getId());
        accountsMap.replace(account.getId(), oldAccount, account);
    }

    @Override
    public void update(List<Account> accounts) {
        for (int i = 0; i < accounts.size(); i++) {
            update(accounts.get(i));
        }
    }

    @Override
    public void delete(long accountId) {
        accountsMap.remove(accountId);
    }

    @Override
    public Account find(long accountId) {
        return accountsMap.get(accountId);
    }

    @Override
    public List<Account> find(List<Long> accountIds) {
        List<Account> accountList = new ArrayList<>();
        for (int i = 0; i < accountIds.size(); i++) {
            Account account = find(accountIds.get(i));
            if (account != null)
                accountList.add(account);
        }
        return accountList;
    }

    @Override
    public List<Account> find(String ownerName) {
        List<Account> accounts = new ArrayList<>();
        for (int i = 0; i < accountsMap.size(); i++) {
            if (accountsMap.get(i).getOwnerName().equalsIgnoreCase(ownerName))
                accounts.add(accountsMap.get(i));
        }
        return accounts;
    }

    @Override
    public List<Account> find(boolean locked) {
        return null;
    }
}
