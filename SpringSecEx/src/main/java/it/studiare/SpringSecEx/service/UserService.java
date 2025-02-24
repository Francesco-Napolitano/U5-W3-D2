package it.studiare.SpringSecEx.service;

import it.studiare.SpringSecEx.model.Users;
import it.studiare.SpringSecEx.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/register")
    public Users register(Users user) {
        return userRepo.save(user);
    }
}
