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
    private List<Account> newslist;
    @BeforeEach
    public void makelist()
    {
        this.acoountlist = new ArrayList<>();
        Account account = new Account();
        account.setUserid("ohyunhoo");
        acoountlist.add(account);

        Account account2 = new Account();
        account2.setUserid("ohyunhoo2");
        acoountlist.add(account2);

        News news = new News();
        news.setUrl("www.naver.com");
        news.setMemo("main naver");
        News news2 = new News();
        news2.setUrl("www.google.com");
        news2.setMemo("main google");

        Collection collection = new Collection();
        collection.setAccount(account);
        account.getCollections().add(collection);
        collection.setNews(news);
        news.getCollectList().add(collection);

        Collection collection2 = new Collection();
        collection2.setAccount(account);
        account.getCollections().add(collection2);
        collection2.setNews(news2);
        news2.getCollectList().add(collection2);


        acoountlist.forEach(x->accountRepository.save(x));
        newsRepository.save(news);
        newsRepository.save(news2);
        collectionRepository.save(collection);
        collectionRepository.save(collection2);
    }

    //Test by H2 Database
    @Test
    public void crudRepository()
    {
        //test
        Account getaccount = accountRepository.findAccountByUserid("ohyunhoo");
        List<Collection> listbyuser = collectionRepository.findCollectionsByAccount(getaccount);
        assertEquals(listbyuser.size(),2);
        listbyuser.stream().map( x -> x.getAccount().getUserid() + " / " + x.getNews().getUrl() + " / " + x.getNews().getMemo())
                .forEach(System.out::println);
    }
}