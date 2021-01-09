package com.example.newscollector.JPA_entity;

import com.example.newscollector.JPA_entity.Collection;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class News {
    @Id @GeneratedValue
    private Long url_no;

    @Column(unique = true)
    private String url;

    private String memo;

    @OneToMany(mappedBy = "news", cascade = CascadeType.ALL)
    private Set<Collection> CollectList = new HashSet<Collection>();

}
