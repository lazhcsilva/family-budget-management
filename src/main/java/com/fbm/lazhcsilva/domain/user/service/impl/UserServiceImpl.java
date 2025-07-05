package com.fbm.lazhcsilva.domain.user.service.impl;

import com.fbm.lazhcsilva.infrastructure.dto.user.UserDTO;
import com.fbm.lazhcsilva.domain.user.model.User;
import com.fbm.lazhcsilva.domain.user.repository.UserRepository;
import com.fbm.lazhcsilva.domain.user.service.UserService;

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
