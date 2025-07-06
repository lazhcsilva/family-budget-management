package com.fbm.user.service;

import com.fbm.user.model.User;
import java.util.List;

public interface UserService {
    List<User> getAll();

    User findById(Long id);

    void insert(User user);

    void update(Long id, User user);

    void delete(Long id);
}
