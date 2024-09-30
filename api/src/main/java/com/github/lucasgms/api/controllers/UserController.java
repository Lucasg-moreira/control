package com.github.lucasgms.api.controllers;

import com.github.lucasgms.api.dtos.user.UserReadDto;
import com.github.lucasgms.api.entities.User;
import com.github.lucasgms.api.exceptions.UserCreationException;
import com.github.lucasgms.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping()
    public ResponseEntity<UserReadDto> createUser(@RequestBody User user) {
        try {
            return ResponseEntity.ok(userService.createUser(user));
        } catch (UserCreationException e) {
            throw new UserCreationException(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
