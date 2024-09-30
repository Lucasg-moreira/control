package com.github.lucasgms.api.services;

import com.github.lucasgms.api.dtos.user.UserReadDto;
import com.github.lucasgms.api.entities.User;
import com.github.lucasgms.api.exceptions.UserCreationException;
import com.github.lucasgms.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserReadDto createUser(User user) throws Exception {
        if (user == null)
            throw new UserCreationException("Falha ao criar o usuário");

        if (user.getEmail() == null)
            throw new UserCreationException("Email é obrigatório!");

        if (user.getName() == null)
            throw new UserCreationException("Nome é obrigatório!");

        if (user.getPassword() == null)
            throw new UserCreationException("A senha é obrigatória!");
        
        if (isUserRegistered(user.getEmail()))
            throw new UserCreationException("Esse usuário já foi cadastrado!");

        User entity = userRepository.save(user);

        return mapToReadDto(entity);
    }

    private boolean isUserRegistered(String email) {
        UserReadDto u = getUserByEmail(email);

        return u != null;
    }

    public UserReadDto getUserByEmail(String email) {
        User user = userRepository.findByEmail(email);

        if (user != null)
            return mapToReadDto(user);

        return null;
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User updateUser(User updatedUser) {
        return userRepository.save(updatedUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    private UserReadDto mapToReadDto(User user) {
        return new UserReadDto(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }
}
