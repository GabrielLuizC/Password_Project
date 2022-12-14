package com.manager.passwordProject.controller;

import com.manager.passwordProject.entity.Password;
import com.manager.passwordProject.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("api/passwords")
public class PasswordController {
    @Autowired
    private PasswordService passwordService;

    @GetMapping
    public ResponseEntity<?> findAll(Pageable pageable, @RequestHeader("access") Long userId) {
        try {
            return ResponseEntity.ok().body(this.passwordService.findAll(pageable, userId));
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id, @RequestHeader("access") Long userId) {
        try {
            return ResponseEntity.ok().body(this.passwordService.findById(id, userId));
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("description/{q}")
    public ResponseEntity<?> findByDetail(Pageable pageable, @PathVariable String q, @RequestHeader("access") Long userId) {
        try {
            return ResponseEntity.ok().body(this.passwordService.findByDetail(pageable, q, userId));
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Password password) {
        try {
            return ResponseEntity.ok().body(this.passwordService.save(password));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping()
    public ResponseEntity<?> update(@RequestBody Password password, @RequestHeader("access") Long userId) {
        try {
            return ResponseEntity.ok().body(this.passwordService.update(password, userId));
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id, @RequestHeader("access") Long userId) {
        try {
            this.passwordService.delete(id, userId);
            return ResponseEntity.ok().build();
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
