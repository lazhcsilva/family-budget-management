package com.fbm.user.service.impl;

import com.fbm.common.handler.BusinessException;
import com.fbm.user.model.User;
import com.fbm.user.repository.UserRepository;
import com.fbm.user.service.UserService;
import java.util.List;
import java.util.Optional;

import com.fbm.user.service.UserValidator;
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
        return user.orElseThrow(() -> new BusinessException("Id not found"));
    }

    @Override
    public void insert(User user) {
        if (user.getFirstName() == null
                || user.getLastName() == null
                || user.getEmail() == null
                || user.getPassword() == null) {
            throw new BusinessException("You must fill in all fields");
        } else if (userValidator.isValidEmail(user.getEmail())) {
            throw new BusinessException("Invalid email");
        } else {
            userRepository.save(user);
        }
    }

    @Override
    public void update(Long id, User user) {
        Optional<User> userDb = userRepository.findById(id);
        if (userDb.isEmpty()) {
            throw new BusinessException("Id not found");
        } else if (userValidator.isValidEmail(user.getEmail())) {
            throw new BusinessException("Invalid email");
        } else {
            userRepository.save(user);
        }
    }

    @Override
    public void delete(Long id) {
        User user = findById(id);
        userRepository.delete(user);
    }
}
