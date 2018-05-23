package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Tweet;
import pl.coderslab.entity.User;
import pl.coderslab.external.BCrypt;
import pl.coderslab.repository.TweetRepository;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.service.TweetService;
import pl.coderslab.service.UserService;
import pl.coderslab.validator.ValidationGroupLogIn;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.validation.groups.Default;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    Validator validator;

    @Autowired
    TweetService tweetService;

    @Autowired
    UserService userService;

    @GetMapping("/user/add")
    public String addUser(Model model){
        model.addAttribute("user",new User());
        return "userForm";
    }

    @PostMapping("/user/add")
    public String addUser(@Valid @ModelAttribute User user,
                          BindingResult result,
                          Model model){
        if (result.hasErrors()) {
            return "userForm";
        }
        User userFromDBByEmail = userService.findUserByEmail(user.getEmail());
        User userFromDBByUsername = userService.findUserByUsername(user.getUsername());
        if ((userFromDBByEmail==null) && (userFromDBByUsername==null)) {
            user.setEnabled(true);
            userService.saveUser(user);
            return "redirect:/";
        } else {
            model.addAttribute("registrationError",1);
            return "userForm";
        }
    }

    @GetMapping("/userpage/{user_id}")
    public String userPage(HttpSession sess, Model model) {
        Long user_id = (Long) sess.getAttribute("user_id");
        if (user_id!=null) {
            model.addAttribute("tweet",new Tweet());
            return "home";
        } else {
            return "redirect:/login";
        }
    }

    @PostMapping("/userpage/{user_id}")
    public String userPage(@Valid @ModelAttribute Tweet tweet,
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


    @GetMapping("user/show/{id}")
    public String showUser(@PathVariable Long id, Model model, HttpSession sess) {
        User user = userService.findUser(id);
        if (user!=null) {
            model.addAttribute("user",user);
            model.addAttribute("tweets",tweetService.findAllTweetsByUserIdOrderByCreatedDesc(id));
            return "userData";
        } else {
            return "redirect:/user/show";
        }
    }

    @GetMapping("user/show")
    public String showAllUsers() {
        return "userList";
    }




//    @GetMapping("/user/{id}/tweets")
//    public String showTweetsByUserId(@PathVariable Long id, Model entity){
//        List<Tweet> tweets = tweetRepository.findAllByUserId(id);
//        entity.addAttribute("tweets",tweets);
//
//        return "TweetByUserId";
//    }
//
//    @GetMapping("/user/search-tweets")
//    public String showTweetsByTitleCreated(Model entity){
//        List<Tweet> tweets = tweetRepository.findAllTweetsByTitleStartingWithSortedByCreated("a%");
//        entity.addAttribute("tweets",tweets);
//
//        return "TweetByTitlePart";
//    }
//
//
//
//    @GetMapping("/user/clear")
//    public String clearUsersandTweets(Model model) {
//        userRepository.deleteAll();
//        return "UserList";
//    }
//
//    @GetMapping("/user/all")
//    public String showUsers(Model model) {
//
//        List<User> users = userRepository.findAll();
//        model.addAttribute("users",users);
//        return "UserList";
//    }
//
//    @GetMapping("/user/delete/{id}")
//    @ResponseBody
//    public String deleteUser(@PathVariable Long id, Model model){
//        userRepository.delete(id);
//        return "User deleted";
//    }
//
//    @GetMapping("/user/edit/{id}")
//    public String updateUser(@PathVariable Long id, Model model){
//        model.addAttribute("user", userRepository.findOne(id));
//        return "UserForm";
//    }
//
//    @PostMapping("/user/edit/{id}")
//    public String updateUser(@Valid @ModelAttribute User user, BindingResult result) {
//        if (result.hasErrors()) {
//            return "UserForm";
//        }
//        userRepository.save(user);
//        return "redirect:/user/all";
//    }
//

//

    ////////////////// MODEL ATTRIBUTES //////////////////////

    @ModelAttribute("tweets")
    public List<Tweet> tweets(){
        return tweetService.findAllTweets();
    }

    @ModelAttribute("user_tweets")
    public List<Tweet> userTweets(){
        return tweetService.findAllTweets();
    }

    @ModelAttribute("users")
    public List<User> users(){
        return userService.findAllUsers();
    }



}