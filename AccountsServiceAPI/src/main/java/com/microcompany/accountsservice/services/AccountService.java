package com.microcompany.accountsservice.services;

import com.microcompany.accountsservice.exception.AccountNotfoundException;
import com.microcompany.accountsservice.model.Account;
import com.microcompany.accountsservice.model.Customer;
import com.microcompany.accountsservice.persistence.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class AccountService implements IAccountService {
    private Logger logger = LoggerFactory.getLogger(AccountService.class);

    @Autowired
    private AccountRepository accountRepository;

    @Override
    @Transactional
    public Account create(Account account) {
        LocalDate current_Date = LocalDate.now();
        account.setOpeningDate(current_Date);
        return accountRepository.save(account);
    }

    @Override
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account getAccount(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new AccountNotfoundException(id));
        Customer owner = null; // Will be gotten from user service
        account.setOwner(owner);
        return account;
    }

    @Override
    public List<Account> getAccountByOwnerId(Long ownerId) {
        return accountRepository.findByOwnerId(ownerId);
    }

    @Override
    @Transactional
    public Account updateAccount(Long id, Account account) {
        Account newAccount = accountRepository.findById(id).orElseThrow(() -> new AccountNotfoundException(id));
        newAccount.setType(account.getType());
        return accountRepository.save(newAccount);
    }

    @Override
    @Transactional
    public Account addBalance(Long id, int amount, Long ownerId) {
        Account newAccount = accountRepository.findById(id).orElseThrow(() -> new AccountNotfoundException(id));
        Customer owner = null;// Will be gotten from user service
        int newBalance = newAccount.getBalance() + amount;
        newAccount.setBalance(newBalance);
        return accountRepository.save(newAccount);
    }

    @Override
    @Transactional
    public Account withdrawBalance(Long id, int amount, Long ownerId) throws Exception {
        Account newAccount = accountRepository.findById(id).orElseThrow(() -> new AccountNotfoundException(id));
        Customer owner = null; // Will be gotten from user service
        int newBalance = newAccount.getBalance() - amount;
        if (newBalance > 0) {
            newAccount.setBalance(newBalance);
            return accountRepository.save(newAccount);
        } else {
            throw new Exception("Insufficient balance");
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new AccountNotfoundException(id));
        this.accountRepository.delete(account);
    }

    @Override
    @Transactional
    public void deleteAccountsUsingOwnerId(Long ownerId) {
        accountRepository.deleteByOwnerId(ownerId);
        /*List<Account> accounts = accountRepository.findByOwnerId(ownerId);
        for (Account account : accounts) {
            this.accountRepository.delete(account);
        }*/
    }


}
