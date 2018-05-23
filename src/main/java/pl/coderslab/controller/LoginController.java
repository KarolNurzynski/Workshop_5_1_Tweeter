package pl.coderslab.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.User;
import pl.coderslab.external.BCrypt;
import pl.coderslab.service.UserService;
import pl.coderslab.validator.ValidEmailPassword;

@Controller
public class LoginController {

    @Autowired
    Validator validator;

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String login(Model model)
    {
        model.addAttribute("user",new User());
        return "loginPage";
    }

    @PostMapping("/login")
    public String login(@Validated({ValidEmailPassword.class}) @ModelAttribute User user,
                        BindingResult result,
                        HttpSession sess,
                        Model model) {
        if (result.hasErrors()) {
            return "loginPage";
        }
        User userFromDB = userService.findUserByEmail(user.getEmail());
        if ((userFromDB == null) || (!BCrypt.checkpw(user.getPassword(), userFromDB.getPassword()))) {
            model.addAttribute("loginError",1);
            return "loginPage";
        } else {
            Long id = userFromDB.getId();
            sess.setAttribute("user_id",id);
            sess.setMaxInactiveInterval(120);
            return "redirect:/";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession sess) {
        sess.invalidate();
        return "redirect:/login";
    }

}