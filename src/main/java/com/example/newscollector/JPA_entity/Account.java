package com.example.newscollector.JPA_entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Account {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_no;

    @Column(nullable = false,unique = true)
    private String userid;

    @Temporal(TemporalType.TIMESTAMP)
    private Date create_date = new Date();

    @OneToMany(mappedBy = "account",cascade = CascadeType.ALL)
    private Set<Collection> collections = new HashSet<>();
}
