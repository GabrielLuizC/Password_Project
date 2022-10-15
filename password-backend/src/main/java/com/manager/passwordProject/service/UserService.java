package com.manager.passwordProject.service;

import com.manager.passwordProject.entity.User;
import com.manager.passwordProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Optional<User> findById(Long id) {return this.userRepository.findById(id);}

    public Page<User> findAll(Pageable pageable) {
        return this.userRepository.findAll(pageable);
    }


    public User login(User user) {
        Optional<User> userDb =  this.userRepository.findByUsername(user.getUsername());
        if (userDb.isPresent()) {
            if (this.comparePw(user.getPassword(), userDb.get().getPassword())) {
                return userDb.get();
            }
        }
        throw new RuntimeException("Usuário não encontrado!!");
    }

    public User updatePassword(User user, Long userId) {
        Optional<User> oldUser = this.userRepository.findById(user.getId());
        if (oldUser.isPresent()) {
            if (this.comparePw(user.getPassword(), oldUser.get().getPassword())) {
                if (user.getId().equals(userId)) {
                    user.setPassword(user.getNewPassword());
                    return this.save(user);
                }
                throw new RuntimeException("Usuário não permitido!!");
            }
            throw new RuntimeException("Senha Inválida!!");
        }
        throw new RuntimeException("Usuário não encontrado!!");
    }

    public User save(User user) {
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        return this.userRepository.save(user);
    }

    public User update(User user) {
        Optional<User> oldUser = this.userRepository.findById(user.getId());
        if (oldUser.isPresent()) {
            if (this.comparePw(user.getPassword(), oldUser.get().getPassword())) {
                return this.save(user);
            }
            throw new RuntimeException("Senha Inválida!!");
        }
        throw new RuntimeException("Usuário não encontrado!!");
    }

    public void delete(Long id) {
        Optional<User> user = this.userRepository.findById(id);
        if (user.isPresent()) {
            this.userRepository.delete(user.get());
            return;
        }
        throw new RuntimeException("Usuário não encontrado!!");
    }

    private boolean comparePw(String p1, String p2) {
        return this.passwordEncoder.matches(p1, p2);
    }


}
