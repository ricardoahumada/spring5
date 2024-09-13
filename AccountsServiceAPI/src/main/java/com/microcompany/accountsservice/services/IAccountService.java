package com.microcompany.accountsservice.services;

import com.microcompany.accountsservice.model.Account;

import java.util.List;

public interface IAccountService {
    Account create(Account account);

    List<Account> getAccounts();

    Account getAccount(Long id);

    List<Account> getAccountByOwnerId(Long ownerId);

    Account updateAccount(Long id, Account account);

    Account addBalance(Long id, int amount, Long ownerId);

    Account withdrawBalance(Long id, int amount, Long ownerId) throws Exception;

    void delete(Long id);

    void deleteAccountsUsingOwnerId(Long ownerId);

}
