package com.example.newscollector.Controller;

import com.example.newscollector.Oauth.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model) {

        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if(user != null){
            System.out.println(user.getName());
            model.addAttribute("username", user.getName());
            model.addAttribute("picture", user.getPicture());
        }

        return "index";
    }

}
