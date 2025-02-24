package it.studiare.SpringSecEx.repo;

import it.studiare.SpringSecEx.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users, Integer> {
    Users findByUsername(String username);
}
