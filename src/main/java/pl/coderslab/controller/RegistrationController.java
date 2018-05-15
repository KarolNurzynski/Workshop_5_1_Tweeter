package pl.coderslab.controller;

import javax.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.model.User;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.service.UserService;
import pl.coderslab.validator.ValidationGroupLogIn;

@Controller
public class RegistrationController {
    @Autowired
    Validator validator;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

    public RegistrationController() {
    }

    @GetMapping({"/registration"})
    public String registerUser(Model model) {
        model.addAttribute("user", new User());
        return "RegistrationForm";
    }

    @PostMapping({"/registration"})
    public String registerUser(@Validated({ValidationGroupLogIn.class}) @ModelAttribute User user, BindingResult result) {
        if (result.hasErrors()) {
            return "RegistrationForm";
        } else {
            user.setEnabled(true);
            this.userService.saveUserPassword(user);
            return "redirect:/user/" + user.getId();
        }
    }
}