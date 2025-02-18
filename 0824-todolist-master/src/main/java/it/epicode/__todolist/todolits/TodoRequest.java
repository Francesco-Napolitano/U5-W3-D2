package it.epicode.__todolist.todolits;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoRequest {
    @NotBlank(message = "Title is required")
    private String title;
    private String description;
}
