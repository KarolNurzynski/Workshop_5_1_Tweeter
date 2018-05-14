package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import pl.coderslab.model.Tweet;
import pl.coderslab.model.User;
import pl.coderslab.repository.TweetRepository;
import pl.coderslab.repository.UserRepository;


import javax.validation.Valid;
import javax.validation.Validator;
import javax.validation.groups.Default;
import java.awt.print.Book;
import java.time.LocalDate;
import java.util.List;

@Controller
public class TweetController {

    @Autowired
    Validator validator;

    @Autowired
    TweetRepository tweetRepository;

    @Autowired
    UserRepository userRepository;



    @GetMapping("/tweet/add")
    public String tweetForm(Model model){
        model.addAttribute("tweet",new Tweet());

        return "TweetForm";
    }

    @PostMapping("/tweet/add")
    public String tweetForm(@Valid @ModelAttribute Tweet tweet, BindingResult result){
        if (result.hasErrors()) {
            return "TweetForm";
        }
        tweet.setCreated(LocalDate.now());
        tweetRepository.save(tweet);
        return "redirect:/tweet/add";
    }




    @ModelAttribute("users")
    public List<User> users(){
        return userRepository.findAll();
    }

    @ModelAttribute("tweets")
    public List<Tweet> tweets(){
        return tweetRepository.findAll();
    }

}