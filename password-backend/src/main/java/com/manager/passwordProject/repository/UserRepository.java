package com.manager.passwordProject.repository;

import com.manager.passwordProject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT user " +
            "FROM User user " +
            "WHERE user.username = :username")
    Optional<User> findByUsername(String username);
}
