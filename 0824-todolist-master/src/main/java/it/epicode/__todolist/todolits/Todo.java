package it.epicode.__todolist.todolits;

import it.epicode.__todolist.auth.AppUser;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Todo")

public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private String title;
    private String description;
    private boolean completed;

    @ManyToOne
    private AppUser appUser;


}
