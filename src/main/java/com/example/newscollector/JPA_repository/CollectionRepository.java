package com.example.newscollector.JPA_repository;

import com.example.newscollector.JPA_entity.Collection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollectionRepository extends JpaRepository<Collection,Long> {
}
