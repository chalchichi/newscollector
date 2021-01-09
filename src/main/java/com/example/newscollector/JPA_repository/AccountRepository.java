package com.example.newscollector.JPA_repository;

import com.example.newscollector.JPA_entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
}
