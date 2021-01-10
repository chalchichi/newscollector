package com.example.newscollector.JPA_entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

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

    @Temporal(TemporalType.TIMESTAMP)
    private Date add_date = new Date();
}
