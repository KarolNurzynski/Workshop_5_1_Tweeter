//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.entity.User;
import pl.coderslab.external.BCrypt;
import pl.coderslab.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void saveUser(User user) {
        String passwordSalt = BCrypt.gensalt();
        String newPass = BCrypt.hashpw(user.getPassword(), passwordSalt);
        user.setPassword(newPass);
        userRepository.save(user);
    }

    public User findUser(Long id) {
        return userRepository.findOne(id);
    }

    public User findUserByEmail (String email) {
     return userRepository.findOneByEmail(email);
    }

    public User findUserByUsername (String username) {
        return userRepository.findOneByUsername(username);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User editUser(User user) {
        return userRepository.save(user);
    }

    public void editUserPassword(User user) {
        String passwordSalt = BCrypt.gensalt();
        String newPass = BCrypt.hashpw(user.getPassword(), passwordSalt);
        user.setPassword(newPass);
        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.delete(id);
    }



}
