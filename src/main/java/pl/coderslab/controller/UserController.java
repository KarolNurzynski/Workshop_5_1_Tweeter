package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Tweet;
import pl.coderslab.model.User;
import pl.coderslab.repository.TweetRepository;
import pl.coderslab.repository.UserRepository;

import javax.validation.Valid;
import javax.validation.Validator;
import java.awt.print.Book;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    Validator validator;

    @Autowired
    TweetRepository tweetRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/{id}/tweets")
    public String showTweetsByUserId(@PathVariable Long id, Model model){
        List<Tweet> tweets = tweetRepository.findAllByUserId(id);
        model.addAttribute("tweets",tweets);

        return "TweetByUserId";
    }

    @GetMapping("/user/search-tweets")
    public String showTweetsByTitleCreated(Model model){
        List<Tweet> tweets = tweetRepository.findAllTweetsByTitleStartingWithSortedByCreated("a%");
        model.addAttribute("tweets",tweets);

        return "TweetByTitlePart";
    }

    @GetMapping("/user/add")
    public String userForm(Model model){
        model.addAttribute("user",new User());

        return "UserForm";
    }

    @PostMapping("/user/add")
    public String userForm(@Valid @ModelAttribute User user, BindingResult result){
        if (result.hasErrors()) {
            return "UserForm";
        }
        userRepository.save(user);
        return "redirect:/user/all";
    }

    @GetMapping("/user/clear")
    public String clearUsersandTweets(Model model) {
        userRepository.deleteAll();
        return "UserList";
    }

    @GetMapping("/user/all")
    public String showUsers(Model model) {

        List<User> users = userRepository.findAll();
        model.addAttribute("users",users);
        return "UserList";
    }

    @GetMapping("/user/delete/{id}")
    @ResponseBody
    public String deleteUser(@PathVariable Long id, Model model){
        userRepository.delete(id);
        return "User deleted";
    }

    @GetMapping("/user/edit/{id}")
    public String updateUser(@PathVariable Long id, Model model){
        model.addAttribute("user", userRepository.findOne(id));
        return "UserForm";
    }

    @PostMapping("/user/edit/{id}")
    public String updateUser(@Valid @ModelAttribute User user, BindingResult result) {
        if (result.hasErrors()) {
            return "UserForm";
        }
        userRepository.save(user);
        return "redirect:/user/all";
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