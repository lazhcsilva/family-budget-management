package com.fbm.user.service;

import com.fbm.user.dto.UserDTO;
import com.fbm.user.model.User;
import com.fbm.user.repository.UserRepository;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return List.of();
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public User fingByName(String name) {
        return null;
    }

    @Override
    public void insert(UserDTO userDTO) {}

    @Override
    public void update(Long id, User user) {}

    @Override
    public void delete(Long id) {}
}
