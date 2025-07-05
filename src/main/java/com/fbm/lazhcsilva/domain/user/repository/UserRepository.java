package com.fbm.lazhcsilva.domain.user;

import java.util.Optional;

import com.fbm.lazhcsilva.domain.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByName(String name);

    Optional<User> findByName(String name);
}
