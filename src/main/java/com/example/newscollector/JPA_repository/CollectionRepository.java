package com.example.newscollector.JPA_repository;

import com.example.newscollector.JPA_entity.Account;
import com.example.newscollector.JPA_entity.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CollectionRepository extends JpaRepository<Collection,Long> {


    List<Collection> findCollectionsByAccount(Account account);
}
