package com.example.newscollector.JPA_entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class Collection {
    @Id @GeneratedValue
    private Long seq;

    @ManyToOne
    private Account account;

    @ManyToOne
    private News news;
}
