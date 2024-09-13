package com.microcompany.accountsservice.persistence;

import com.microcompany.accountsservice.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
public interface AccountRepository extends JpaRepository<Account, Long> {
    public List<Account> findByOwnerId(Long OwnerId);
    @Transactional
    public void deleteByOwnerId(Long OwnerId);
}
