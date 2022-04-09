package com.survivingcodingbootcamp.blog.controller;

import com.survivingcodingbootcamp.blog.model.Hashtag;
import com.survivingcodingbootcamp.blog.model.Post;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.survivingcodingbootcamp.blog.repository.HashtagRepository;
import com.survivingcodingbootcamp.blog.repository.PostRepository;
import org.springframework.stereotype.Controller;
@Controller
@RequestMapping("/posts")
public class PostController {
    private PostRepository postRepo;
    private HashtagRepository hashTagRepo;

    public PostController(PostRepository postRepo,HashtagRepository hashTagRepo) {
        this.postRepo = postRepo;
        this.hashTagRepo =hashTagRepo;
    }

    @GetMapping("/{id}")
    public String displaySinglePost(@PathVariable long id, Model model) {
        model.addAttribute("post", postRepo.findById(id).get());
        return "single-post-template";
    }
    @PostMapping("/{id}")
    public String addHashtag(@PathVariable long id, @RequestParam String addHashtag, @RequestParam String desc, Model model){
        Post post = postRepo.findById(id).get();
        Hashtag hashtag = new Hashtag(addHashtag);
       post.addHashtag(hashtag);
        hashTagRepo.save(hashtag);
        postRepo.save(post);
        return "redirect:/posts/"+ id;
    }

}

