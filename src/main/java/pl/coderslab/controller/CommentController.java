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
import java.util.List;

@Controller
public class CommentController {

    @Autowired
    Validator validator;

    @Autowired
    TweetService tweetService;

    @Autowired
    UserService userService;

    @Autowired
    CommentService commentService;

    @GetMapping("/comment/add/{tweet_id}")
    public String addTweet(Model model){
        model.addAttribute("comment",new Comment());
        return "commentForm";
    }

    @PostMapping("/comment/add/{tweet_id}")
    public String addTweet(@Valid @ModelAttribute Comment comment,
                           BindingResult result,
                           @PathVariable Long tweet_id,
                           HttpSession sess){
        if (result.hasErrors()) {
            return "commentForm";
        }
        Long user_id = (Long) sess.getAttribute("user_id");
        comment.setUser(userService.findUser(user_id));
        comment.setTweet(tweetService.findTweet(tweet_id));
        comment.setCreated(LocalDateTime.now());
        commentService.saveComment(comment);
        return "redirect:/";
    }

    //////////////// MODEL ATRIBUTES //////////////////////

    @ModelAttribute("comments")
    public List<Comment> comments() {
        return commentService.findAllCommentsOrderByCreatedDesc();
    }


    @ModelAttribute("tweets")
    public List<Tweet> tweets(){
    return tweetService.findAllTweets();
    }

    @ModelAttribute("users")
    public List<User> users(){
        return userService.findAllUsers();
    }


}