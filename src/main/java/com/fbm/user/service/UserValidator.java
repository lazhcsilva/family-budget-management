package com.fbm.user.service;

import com.fbm.user.model.User;
import com.fbm.user.repository.UserRepository;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.stereotype.Component;

@Component
public class UserValidator {

    private final UserRepository userRepository;

    public UserValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean isEmailValid(String email) {
        String regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return !matcher.matches();
    }

    public boolean registeredEmail(String email) {
        User userRegistered = userRepository.findByUserEmail(email);
        return userRegistered != null;
    }

    public boolean isNewEmail(Long id, User user) {
        User newUser = userRepository.findByUserEmail(user.getEmail());
        if (newUser == null) {
            return true;
        }
        return !id.equals(newUser.getId());
    }
}
