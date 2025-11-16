package org.example.auth.Services;


import org.example.auth.Models.LoginUser;
import org.example.auth.Models.User;
import org.example.auth.Repositories.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

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

        System.out.println(newUser);


        if(userRepository.findByEmail(newUser.getEmail()).isPresent()) {
            result.rejectValue("email", "Unique", "Email is already in use!");
        }

        if(!newUser.getPassword().equals(newUser.getConfirm())) {
            result.rejectValue("confirm", "Matches", "Passwords must match!");
        }

        if (Period.between(newUser.getBirthday(), LocalDate.now()).getYears() < 10) {
            result.rejectValue("birthday", "TooYoung", "You must be at least 10 years old to register");
        }

        if(result.hasErrors()) {
            return null;
        }

        String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        newUser.setPassword(hashed);

        return userRepository.save(newUser);
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
