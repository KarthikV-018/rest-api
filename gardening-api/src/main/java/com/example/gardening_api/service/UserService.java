package com.example.gardening_api.service;

import com.example.gardening_api.model.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    User createUser(User user);
    Optional<User> getUserById(Long id);
    List<User> getAllUsers();
    Optional<User> getUserByUsername(String username);
    Optional<User> getUserByEmail(String email);  
    User updateUser(Long id, User userDetails);   
    void deleteUser(Long id);
}
