package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Message;
import pl.coderslab.entity.Tweet;
import pl.coderslab.entity.User;
import pl.coderslab.service.MessageService;
import pl.coderslab.service.TweetService;
import pl.coderslab.service.UserService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.Validator;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class MessageController {

    @Autowired
    Validator validator;

    @Autowired
    TweetService tweetService;

    @Autowired
    UserService userService;

    @Autowired
    MessageService messageService;

    @GetMapping("/message/add/{sender_id}/{receiver_id}")
    public String sendMessage(Model model,
                              HttpSession sess,
                              @PathVariable Long sender_id) {
        Long user_id = (Long) sess.getAttribute("user_id");
        if (user_id==sender_id) {
            model.addAttribute("message", new Message());
            return "messageForm";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/message/add/{sender_id}/{receiver_id}")
    public String sendMessage(@Valid @ModelAttribute Message message,
                              BindingResult result,
                              @PathVariable Long sender_id,
                              @PathVariable Long receiver_id,
                              Model model) {
        if (result.hasErrors()) {
            return "messageForm";
        }
        message.setSender(userService.findUser(sender_id));
        message.setReceiver(userService.findUser(receiver_id));
        message.setCreated(LocalDateTime.now());
        messageService.saveMessage(message);
        List<Message> messages = messageService.findAllMessagesOrderByCreatedDesc();
        model.addAttribute("messages", messages);
        return "messageList";
    }



//    @GetMapping("/tweet/add")
//    public String addTweet(Model model){
//        model.addAttribute("tweet",new Tweet());
//        return "tweetForm";
//    }
//
//    @PostMapping("/tweet/add")
//    public String addTweet(@Valid @ModelAttribute Tweet tweet, BindingResult result){
//        if (result.hasErrors()) {
//            return "tweetForm";
//        }
//        tweet.setCreated(LocalDateTime.now());
//        tweetService.saveTweet(tweet);
//        return "redirect:/tweet/show";
//    }
//
//    @GetMapping("tweet/show")
//    public String showAllTweets() {
//        return "tweetList";
//    }
//
//    @GetMapping("tweet/show/{id}")
//    public String showAllTweets(@PathVariable Long id, Model model) {
//        model.addAttribute("tweet", tweetService.findTweet(id));
//        return "tweetData";
//    }
//
//
//
////
////
////
////
//
//    @ModelAttribute("tweets")
//    public List<Tweet> tweets(){
//    return tweetService.findAllTweets();
//    }
//
//    @ModelAttribute("users")
//    public List<User> users(){
//        return userService.findAllUsers();
//    }

    ////////////////////   MODEL ATTRIBUTES   /////////////

    @ModelAttribute("messages")
    public List<Message> messages() {
        return messageService.findAllMessagesOrderByCreatedDesc();
    }

}