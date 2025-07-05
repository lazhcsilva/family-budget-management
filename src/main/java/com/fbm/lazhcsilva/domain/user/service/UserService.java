package com.fbm.lazhcsilva.domain.user;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User findById(Long id);

    User fingByName(String name);

    void insert(UserDTO userDTO);

    void update(Long id, User user);

    void delete(Long id);
}
