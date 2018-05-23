package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Comment;
import pl.coderslab.entity.Tweet;
import pl.coderslab.entity.User;
import pl.coderslab.service.CommentService;
import pl.coderslab.service.TweetService;
import pl.coderslab.service.UserService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.Validator;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    Validator validator;

    @Autowired
    TweetService tweetService;

    @Autowired
    UserService userService;

    @Autowired
    CommentService commentService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("tweet",new Tweet());
        return "home";
    }
//        Long user_id = (Long) sess.getAttribute("user_id");
//        if (user_id!=null) {
//            model.addAttribute("tweet",new Tweet());
//            return "home";
//        } else {
//            return "redirect:/login";
//        }
//    }

    @PostMapping("/")
    public String home(@Valid @ModelAttribute Tweet tweet,
                       BindingResult result,
                       HttpSession sess) {
        if (result.hasErrors()) {
            return "home";
        }
        Long user_id = (Long) sess.getAttribute("user_id");
        tweet.setUser(userService.findUser(user_id));
        tweet.setCreated(LocalDateTime.now());
        tweetService.saveTweet(tweet);
        return "redirect:/";
    }

//        if (result.hasErrors()) {
//            return "home";
//        }
//        Long user_id = (Long) sess.getAttribute("user_id");
//        tweet.setUser(userService.findUser(user_id));
//        tweet.setCreated(LocalDateTime.now());
//        tweetService.saveTweet(tweet);
//        return "redirect:/";
//    }

    ////////////////// MODEL ATTRIBUTES //////////////////////

    @ModelAttribute("tweets")
    public List<Tweet> tweets() {
        return tweetService.findAllTweetsOrderByCreatedDesc();
    }

    @ModelAttribute("users")
    public List<User> users(){
        return userService.findAllUsers();
    }

    @ModelAttribute("comments")
    public List<Comment> comments() {
        return commentService.findAllCommentsOrderByCreatedDesc();
    }

}
