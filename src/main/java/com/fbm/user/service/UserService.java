package com.fbm.user.service;

import com.fbm.user.model.User;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface UserService {
    List<User> getAll();

    User findById(Long id);

    User findByEmail(String email);

    void insert(User user) throws NoSuchAlgorithmException;

    void update(Long id, User user);

    void delete(Long id);
}
