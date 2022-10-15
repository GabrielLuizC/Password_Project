package com.manager.passwordProject.repository;

import com.manager.passwordProject.entity.Password;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface PasswordRepository extends JpaRepository<Password, Long> {
    @Query("SELECT password " +
            "FROM Password password " +
            "WHERE password.user.id = :userId " +
            "ORDER BY password.id " +
            "DESC")
    Page<Password> findAll(Pageable pageable, Long userId);

    @Query("SELECT password " +
            "FROM Password password " +
            "WHERE password.detail " +
            "LIKE CONCAT('%', :q, '%') " +
            "AND password.user.id = :userId " +
            "ORDER BY password.id " +
            "DESC")
    Page<Password> findByDetail(Pageable pageable, String q, Long userId);

    @Query("SELECT password " +
            "FROM Password password " +
            "WHERE password.id = :id " +
            "AND password.user.id = :userId")
    Optional<Password> findById(Long id, Long userId);
}
