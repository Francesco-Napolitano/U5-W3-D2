package it.epicode.__todolist.todolits;


import it.epicode.__todolist.auth.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    public List<Todo> findAllByAppUser(AppUser appUser);
}
