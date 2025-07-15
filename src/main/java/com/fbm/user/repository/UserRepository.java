package com.fbm.user.repository;

import com.fbm.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT e FROM User e WHERE e.email = (:email)")
    User findByUserEmail(@Param("email") String email);
}
