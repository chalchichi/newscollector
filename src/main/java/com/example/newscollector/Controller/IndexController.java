package com.example.newscollector.Controller;

import com.example.newscollector.JPA_entity.Account;
import com.example.newscollector.JPA_entity.Collection;
import com.example.newscollector.JPA_repository.AccountRepository;
import com.example.newscollector.JPA_repository.CollectionRepository;
import com.example.newscollector.JPA_repository.NewsRepository;
import com.example.newscollector.Oauth.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class IndexController {
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    CollectionRepository collectionRepository;

    @Autowired
    NewsRepository newsRepository;

    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model) {

        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        if(user != null){
            if(!accountRepository.findAccountByUserid("user").isPresent()) {
                Account account = new Account();
                account.setUserid(user.getName());
                accountRepository.save(account);
            }
            model.addAttribute("username", user.getName());
            model.addAttribute("picture", user.getPicture());
            return "index2";
        }
        else
        {
            return "index";
        }
    }

    @GetMapping("/data")
    public List<Collection> getData()
    {
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        Optional<Account> opgetaccount = accountRepository.findAccountByUserid("user");
        if(opgetaccount.isPresent())
        {
            return collectionRepository.findCollectionsByAccount(opgetaccount.get());
        }
        else
        {
            return null;
        }
    }
}
