package com.example.newscollector.Controller;

import com.example.newscollector.JPA_entity.Account;
import com.example.newscollector.Oauth.SessionUser;
import com.example.newscollector.VO.Collection_VO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class RestContorller {

    private final HttpSession httpSession;

    @RequestMapping(value="/Save", method= RequestMethod.POST)
    public void saveDate(Model model, Collection_VO collection_vo)
    {
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        String URI = collection_vo.getUri();
    }

}
