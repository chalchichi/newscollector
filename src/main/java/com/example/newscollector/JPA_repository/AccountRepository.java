package com.example.newscollector.JPA_repository;

import com.example.newscollector.JPA_entity.Account;
import com.sun.istack.Nullable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Long> {

    @Nullable
    Optional<Account> findAccountByUserid(String userid);

}
