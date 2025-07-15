package com.fbm.user.service;

import com.fbm.user.model.User;
import com.fbm.user.repository.UserRepository;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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

    public String encryptPassword(String password) throws NoSuchAlgorithmException {
        String encryptedPassword = "";
        MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
        byte[] messageDigest = algorithm.digest(password.getBytes(StandardCharsets.UTF_8));

        StringBuilder hexString = new StringBuilder();

        for (byte b : messageDigest) {
            hexString.append(String.format("%02X", 0xFF & b));
        }

        encryptedPassword = hexString.toString();
        algorithm.reset();
        return encryptedPassword;
    }
}
