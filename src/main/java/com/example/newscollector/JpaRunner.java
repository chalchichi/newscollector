package com.example.newscollector;

import com.example.newscollector.JPA_entity.Account;
import com.example.newscollector.JPA_entity.Collection;
import com.example.newscollector.JPA_entity.News;
import com.example.newscollector.JPA_repository.AccountRepository;
import com.example.newscollector.JPA_repository.CollectionRepository;
import com.example.newscollector.JPA_repository.NewsRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

    private List<Account> acoountlist = new ArrayList<>();

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    CollectionRepository collectionRepository;

    @Autowired
    NewsRepository newsRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {


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
    }

}
