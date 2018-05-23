package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import pl.coderslab.entity.Tweet;
import pl.coderslab.entity.User;
import pl.coderslab.repository.TweetRepository;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.service.TweetService;
import pl.coderslab.service.UserService;


import javax.validation.Valid;
import javax.validation.Validator;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class TweetController {

    @Autowired
    Validator validator;

    @Autowired
    TweetService tweetService;

    @Autowired
    UserService userService;


    @GetMapping("/tweet/add")
    public String addTweet(Model model){
        model.addAttribute("tweet",new Tweet());
        return "tweetForm";
    }

    @PostMapping("/tweet/add")
    public String addTweet(@Valid @ModelAttribute Tweet tweet,
                           BindingResult result){
        if (result.hasErrors()) {
            return "tweetForm";
        }
        tweet.setCreated(LocalDateTime.now());
        tweetService.saveTweet(tweet);
        return "redirect:/tweet/show";
    }

    @GetMapping("tweet/show")
    public String showAllTweets() {
        return "tweetList";
    }

    @GetMapping("tweet/show/{id}")
    public String showAllTweets(@PathVariable Long id, Model model) {
        model.addAttribute("tweet", tweetService.findTweet(id));
        return "tweetData";
    }



//
//
//
//

    @ModelAttribute("tweets")
    public List<Tweet> tweets(){
    return tweetService.findAllTweets();
    }

    @ModelAttribute("users")
    public List<User> users(){
        return userService.findAllUsers();
    }


}