package com.example.newscollector.JPA_entity;

import com.example.newscollector.JPA_repository.AccountRepository;
import com.example.newscollector.JPA_repository.CollectionRepository;
import com.example.newscollector.JPA_repository.NewsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@DataJpaTest
class CollectionTest {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    CollectionRepository collectionRepository;

    @Autowired
    NewsRepository newsRepository;
    private List<Account> acoountlist;

    @BeforeEach
    public void makelist()
    {
        this.acoountlist = new ArrayList<>();
    }

    //Test by H2 Database
    @Test
    public void crudRepository()
    {
        Account account = new Account();
        account.setUserid("ohyunhoo");
        acoountlist.add(account);

        Account account2 = new Account();
        account2.setUserid("ohyunhoo2");
        acoountlist.add(account2);

        News news = new News();
        news.setUrl("www.naver.com");
        news.setMemo("main naver");

        Collection collection = new Collection();
        collection.setAccount(account);
        collection.setNews(news);
        news.getCollectList().add(collection);

        acoountlist.forEach(x->accountRepository.save(x));
        collectionRepository.save(collection);
        newsRepository.save(news);
        collectionRepository.findAll().stream().map(x ->x.getAccount().getUserid() + " / " + x.getNews().getUrl())
                .forEach(System.err::println);
        assertFalse(collectionRepository.findAll().isEmpty());
    }
}