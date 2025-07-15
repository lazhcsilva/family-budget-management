package com.fbm.user.service.impl;

import com.fbm.common.handler.BusinessException;
import com.fbm.user.model.User;
import com.fbm.user.repository.UserRepository;
import com.fbm.user.service.UserService;
import com.fbm.user.service.UserValidator;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserValidator userValidator;

    public UserServiceImpl(UserRepository userRepository, UserValidator userValidator) {
        this.userRepository = userRepository;
        this.userValidator = userValidator;
    }

    @Override
    public List<User> getAll() {
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            throw new BusinessException("No users saved.");
        }
        return users;
    }

    @Override
    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new BusinessException("Id not found."));
    }

    @Override
    public User findByEmail(String email) {
        User user = userRepository.findByUserEmail(email);
        if (user == null) {
            throw new BusinessException("No users found with this email.");
        }
        return user;
    }

    @Override
    public void insert(User user) throws NoSuchAlgorithmException {
        if (user.getFirstName() == null
                || user.getLastName() == null
                || user.getEmail() == null
                || user.getPassword() == null) {
            throw new BusinessException("You must fill in all fields.");
        }

        if (userValidator.isEmailValid(user.getEmail())) {
            throw new BusinessException("Invalid email.");
        }

        if (userValidator.registeredEmail(user.getEmail())) {
            throw new BusinessException("Email registered.");
        }

        String password = user.getPassword();
        String encryptedPassword = userValidator.encryptPassword(password);
        user.setPassword(encryptedPassword);

        userRepository.save(user);
    }

    @Override
    public void update(Long id, User user) {
        Optional<User> userDb = userRepository.findById(id);
        if (userDb.isEmpty()) {
            throw new BusinessException("Id not found.");
        }

        if (userValidator.isEmailValid(user.getEmail())) {
            throw new BusinessException("Invalid email.");
        }

        if (userValidator.isNewEmail(id, user)) {
            throw new BusinessException("The email is different. Insert current email.");
        }

        userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        User user = findById(id);
        userRepository.delete(user);
    }
}
