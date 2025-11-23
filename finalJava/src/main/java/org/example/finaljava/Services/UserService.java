package org.example.finaljava.Services;



import org.example.finaljava.Models.LoginUser;
import org.example.finaljava.Models.User;
import org.example.finaljava.Repositories.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(User newUser, BindingResult result) {
        System.out.println("entered3");
        System.out.println(newUser);


        if(userRepository.findByEmail(newUser.getEmail()).isPresent()) {
            result.rejectValue("email", "Unique", "Email is already in use!");
        }

        if(!newUser.getPassword().equals(newUser.getConfirm())) {
            result.rejectValue("confirm", "Matches", "Passwords must match!");
        }

        if(result.hasErrors()) {
            return null;
        }

        String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        newUser.setPassword(hashed);

        return userRepository.save(newUser);
    }

    public User findUser(Long id){
        Optional optional = userRepository.findById(id);
        if(optional.isPresent()){
            return (User) optional.get();
        }
        return null;
    }

    public User login(LoginUser newLoginUser, BindingResult result) {
        Optional<User> potentialUser = userRepository.findByEmail(newLoginUser.getLoginEmail());
        if(!potentialUser.isPresent()) {
            result.rejectValue("loginEmail", "NotFound", "Invalid email or  password!");
            return null;
        }

        User user = potentialUser.get();

        if(!BCrypt.checkpw(newLoginUser.getLoginPassword(), user.getPassword())) {
            result.rejectValue("loginEmail", "Invalid", "Invalid email or  password!");
        }

        if(result.hasErrors()) {
            return null;
        }

        return user;
    }



}

