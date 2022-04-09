package com.survivingcodingbootcamp.blog.controller;


import com.survivingcodingbootcamp.blog.repository.HashtagRepository;
import com.survivingcodingbootcamp.blog.repository.PostRepository;
import com.survivingcodingbootcamp.blog.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;




@Controller
@RequestMapping("/hashtags")
public class HashtagController {
    private HashtagRepository hashtagRepo;
    private PostRepository postRepo;
    private TopicRepository topicRepo;



    @Autowired
    public HashtagController(HashtagRepository hashtagRepo , PostRepository postRepo, TopicRepository topicRepo ){
        this.hashtagRepo = hashtagRepo;
        this.postRepo = postRepo;
        this.topicRepo = topicRepo;
    }
    @GetMapping("/{id}")
    
    public  String displayingSingleHashtag(@PathVariable Long id, Model model){
        model.addAttribute("hashtag", hashtagRepo.findById(id).get());
        return "single-hashtag-template";
    }

    @PostMapping("/add/{id}")
    public String addHashtag(@PathVariable Long id, @RequestParam String hashtag){
        if(hashtag.charAt(0) != '#'){
            hashtag = "#" + hashtag;
        }
        return "redirect:/posts/" + id;


    }



 @GetMapping("")

    public String allHashtag(Model model){

        model.addAttribute("hashtags",hashtagRepo.findAll());
        return "all-hashtags-template";
 }


}


