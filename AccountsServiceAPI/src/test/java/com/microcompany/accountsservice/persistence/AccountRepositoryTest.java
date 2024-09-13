package com.microcompany.accountsservice.persistence;

import com.microcompany.accountsservice.model.Account;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AccountRepositoryTest {

    @Autowired
    AccountRepository repository;

    @Test
    @Order(1)
    void givenAccounts_WhenFindByOwnerId_ThenIsGreaterThan0() {
        List<Account> accounts = repository.findByOwnerId(1L);
        System.out.println(accounts);
//        assertNotNull(accounts);
        assertTrue(accounts.size() > 0);
    }

    @Test
    @Order(2)
    void givenAccounts_WhenDeleteByOwnerId_ThenNull() {
        repository.deleteByOwnerId(1L);
        List<Account> accounts = repository.findByOwnerId(1L);
//        System.out.println(accounts);
        assertEquals(accounts.size(), 0);
    }
}