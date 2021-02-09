package com.simpleshop.Services;

import com.simpleshop.Models.User;
import com.simpleshop.Repositories.UserRepo;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    public void addUser(User user) {
        userRepo.save(user);
    }
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public Optional<User> findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    public Long getIdActualLoggedUser(Principal principal) {
        return userRepo.findByUsername(principal.getName()).get().getId();
    }
}
