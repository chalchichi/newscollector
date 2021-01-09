package com.example.newscollector.JPA_entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@ToString
public class Collection {
    @Id @GeneratedValue
    private Long seq;

    @ManyToOne
    private Account account;

    @ManyToOne
    private News news;
}
