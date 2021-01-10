package com.example.newscollector.JPA_repository;

import com.example.newscollector.JPA_entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account,Long> {
    Account findAccountByUserid(String userid);
}
