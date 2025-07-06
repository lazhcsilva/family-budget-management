package com.fbm.user.service.impl;

import com.fbm.common.handler.BusinessException;
import com.fbm.user.model.User;
import com.fbm.user.repository.UserRepository;
import com.fbm.user.service.UserService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            throw new BusinessException("No users saved.");
        }
        return List.of();
    }
}
