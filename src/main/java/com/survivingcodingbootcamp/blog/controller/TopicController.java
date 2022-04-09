package com.survivingcodingbootcamp.blog.controller;

import com.survivingcodingbootcamp.blog.model.Topic;
import com.survivingcodingbootcamp.blog.model.Post;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.survivingcodingbootcamp.blog.repository.PostRepository;
import com.survivingcodingbootcamp.blog.repository.TopicRepository;

@Controller
@RequestMapping("/topics")
public class TopicController {

    private TopicRepository topicRepo;
    private PostRepository postRepo;

    public TopicController(TopicRepository topicRepo, PostRepository postRepo) {

        this.topicRepo = topicRepo;
        this.postRepo = postRepo;
    }

    @RequestMapping("/{id}")
    public String displaySingleTopic(@PathVariable long id, Model model) {
        model.addAttribute("topic", topicRepo.findById(id).get());
        return "single-topic-template";
    }

    @PostMapping("/{id}")
    public String addNewPost(@PathVariable long id, @RequestParam String title, @RequestParam String content,
            @RequestParam String author, Model model) {
        Topic topic = topicRepo.findById(id).get();
        Post post = new Post(title, topic, content, author);
        postRepo.save(post);

        return "redirect:/topics/" + id;
    }

}
