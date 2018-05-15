//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.external.BCrypt;
import pl.coderslab.model.User;
import pl.coderslab.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public UserService() {
    }

    public void saveUserPassword(User user) {
        String newPass = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(newPass);
        this.userRepository.save(user);
    }
}
