package com.microcompany.accountsservice.services;

import com.microcompany.accountsservice.model.Account;
import com.microcompany.accountsservice.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IAccountServiceTest {
    @Autowired
    AccountService service;

    @Test
    void testBean() {
        assertNotNull(service);
    }

    @Test
    void create() {
        Account newAccount = new Account(null, "Personal", LocalDate.now(), 100, new Customer(null, "Ricardo", "r@r.com"));
        service.create(newAccount);
        assertNotNull(newAccount);
        assertTrue(newAccount.getId() > 0);
    }

    @Test
    void getAccounts() {
        List<Account> accounts = service.getAccounts();
        assertNotNull(accounts);
        assertTrue(accounts.size() > 0);
    }

    @Test
    void getAccount() {
        Account account = service.getAccount(1L);
        assertNotNull(account);
        assertEquals(account.getId(), 1L);
    }

    @Test
    void getAccountByOwnerId() {
        List<Account> accounts = service.getAccountByOwnerId(1L);
        assertNotNull(accounts);
        assertTrue(accounts.size() > 0);
    }

    @Test
    void updateAccount() {
        Account account = new Account();
        account.setType("Company");
        service.updateAccount(1L, account);

        Account updatedAccount = service.getAccount(1L);
        assertNotNull(updatedAccount);
        assertEquals(updatedAccount.getType(), "Company");
    }

    @Test
    void addBalance() {
        Account originalAccount = service.getAccount(1L);
        int amount = 10;

        service.addBalance(1L, amount, 1L);

        Account updatedAccount = service.getAccount(1L);
        assertEquals(updatedAccount.getBalance(), originalAccount.getBalance() + amount);
    }

    @Test
    void withdrawBalanceOK() throws Exception {
        Account originalAccount = service.getAccount(1L);
        int amount = 10;

        service.withdrawBalance(1L, amount, 1L);

        Account updatedAccount = service.getAccount(1L);
        assertEquals(updatedAccount.getBalance(), originalAccount.getBalance() - amount);
    }

    @Test
    void withdrawBalanceNOK() {
        Account originalAccount = service.getAccount(1L);
        int amount = 1000;

        assertThrows(Exception.class, () -> {
            service.withdrawBalance(1L, amount, 1L);
        });
    }

    @Test
    void delete() {
        service.delete(1L);
        assertThrows(Exception.class, () -> {
            Account originalAccount = service.getAccount(1L);
        });
    }

    @Test
    void deleteAccountsUsingOwnerId() {
        service.deleteAccountsUsingOwnerId(1L);
        List<Account> accounts = service.getAccountByOwnerId(1L);
        assertEquals(accounts.size(), 0);
    }
}