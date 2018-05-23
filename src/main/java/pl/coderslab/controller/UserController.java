package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Tweet;
import pl.coderslab.entity.User;
import pl.coderslab.service.TweetService;
import pl.coderslab.service.UserService;
import pl.coderslab.validator.ValidEmail;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.Validator;
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

    @GetMapping("user/show")
    public String showAllUsers() {
        return "userList";
    }

    @GetMapping("user/show/{user_id}")
    public String showUser(@PathVariable Long user_id, Model model, HttpSession sess) {
        User user = userService.findUser(user_id);
        if (user != null) {
            model.addAttribute("user", user);
            model.addAttribute("tweets", tweetService.findAllTweetsByUserIdOrderByCreatedDesc(user_id));
            return "userData";
        } else {
            return "redirect:/user/show";
        }
    }

    @GetMapping("/userprofile/{user_id}")
    public String userPage(@PathVariable Long user_id, Model model) {
        User user = userService.findUser(user_id);
        user.setPassword("");
        model.addAttribute("user",user);
        return "userProfile";
    }

    @RequestMapping(value="/userprofile/{user_id}", method=RequestMethod.POST, params="submit=changeEmail")
    public String editEmail(@Validated({ValidEmail.class}) @ModelAttribute User user,
                       BindingResult result,
                       @PathVariable Long user_id) {
        if (result.hasErrors()) {
            return "userProfile";
        }
        user.setPassword(userService.findUser(user_id).getPassword());
        userService.editUser(user);
        return "redirect:/logout";
    }


    @RequestMapping(value="/userprofile/{user_id}", method=RequestMethod.POST, params="submit=changePassword")
    public String editPassword(@Validated({ValidEmail.class}) @ModelAttribute User user,
                           BindingResult result,
                           @PathVariable Long user_id) {

        if (result.hasErrors()) {
            return "userProfile";
        }
        userService.saveUser(user);
        return "redirect:/logout";
    }

    @GetMapping("/user/delete/{user_id}")
    @ResponseBody
    public String deleteUser(@PathVariable Long user_id, Model model){
        userService.deleteUser(user_id);
        return "redirect:/logout";
    }

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