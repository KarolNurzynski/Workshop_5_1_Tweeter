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
        return "redirect:/message/show/"+sender_id;
    }

    @GetMapping("/message/show/{sender_id}")
    public String viewMessages(@PathVariable Long sender_id, HttpSession sess, Model model) {
        Long user_id = (Long) sess.getAttribute("user_id");
        if (sender_id==user_id) {
            model.addAttribute("receivedMessages",messageService.findAllMessagesByReceiverIdOrderByCreatedDesc(user_id));
            model.addAttribute("sentMessages",messageService.findAllMessagesBySenderIdOrderByCreatedDesc(user_id));
            return "messageList";
        } else {
            return "redirect:/message/show/"+sender_id;
        }
    }

    @PostMapping("/message/show/{sender_id}")
    public String viewMessages(@PathVariable Long sender_id) {
        return "redirect:/message/show/"+sender_id;
    }


    @GetMapping("/message/showMessage/{message_id}")
    public String showMessage(@PathVariable Long message_id,
                              HttpSession sess,
                              Model model) {
        Long user_id = (Long) sess.getAttribute("user_id");
        Message message = messageService.findMessage(message_id);
        if ((message.getSender().getId()==user_id)) {
            model.addAttribute("message",message);
            return "messageData";
        } else if ((message.getReceiver().getId()==user_id)) {
            message.setReadStatus(1);
            messageService.saveMessage(message);
            model.addAttribute("message",message);
            return "messageData";
        }else {
            return "redirect:/message/show/"+user_id;
        }
    }

    ////////////////////   MODEL ATTRIBUTES   /////////////

    @ModelAttribute("messages")
    public List<Message> messages() {
        return messageService.findAllMessagesOrderByCreatedDesc();
    }

}