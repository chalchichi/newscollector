package com.example.newscollector.Oauth;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GUserRepository extends JpaRepository<GUser, Long> {

    Optional<GUser> findByEmail(String email);
}
