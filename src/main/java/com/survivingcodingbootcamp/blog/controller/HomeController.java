package com.survivingcodingbootcamp.blog.controller;

import com.survivingcodingbootcamp.blog.repository.TopicRepository;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class HomeController {
    private TopicRepository topicRepo;

    public HomeController(TopicRepository topicRepo) {

        this.topicRepo = topicRepo;
    }

    @GetMapping("/")
    public String displayHomePage(Model model) {
        model.addAttribute("topics", topicRepo.findAll());
        return "home-template";
    }
}
