package com.wiley.beginningspring.ch7.service;


import com.wiley.beginningspring.ch7.dao.AccountDao;
import com.wiley.beginningspring.ch7.model.Account;

public class AccountServiceImpl implements AccountService{

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void transferMoney(long sourceAccountId, long targetAccountId, double amount) {
        Account sourceAccount = accountDao.find(sourceAccountId);
        Account targetAccount = accountDao.find(targetAccountId);
        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
        targetAccount.setBalance(targetAccount.getBalance() + amount);

        accountDao.update(sourceAccount);
        accountDao.update(targetAccount);
    }

    @Override
    public void depositMoney(long accountId, double amount) throws Exception {
        Account depositAccount = accountDao.find(accountId);
        depositAccount.setBalance(depositAccount.getBalance() + amount);
        accountDao.update(depositAccount);
    }

    @Override
    public Account getAccount(long accountId) {
        return accountDao.find(accountId);
    }
}
