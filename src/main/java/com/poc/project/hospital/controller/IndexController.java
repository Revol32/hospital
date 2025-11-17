package com.poc.project.hospital.controller;

import com.poc.project.hospital.dto.Message;
import com.poc.project.hospital.entity.MyUser;
import com.poc.project.hospital.repository.TextContentRepository;
import com.poc.project.hospital.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import static com.poc.project.hospital.util.StringConstants.ENG_GREETING;

@Controller
public class IndexController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TextContentRepository textContentRepository;

    @GetMapping("/")
    public String login(Authentication authentication, Model model) {
        MyUser user = userRepository.getUserByLogin(authentication.getName());
        if (!model.containsAttribute("authorized_user_name")) {
            model.addAttribute("authorized_user_name", user.getName() + " " + user.getSurname());
        }
        model.addAttribute("main_page_content", textContentRepository.getTextContentByUserAndPage("index").getContent());
        Message greetingMessage = new Message();
        greetingMessage.setMessage(ENG_GREETING + authentication.getName());
        model.addAttribute("message", greetingMessage.getMessage());
        return "index";
    }

}
