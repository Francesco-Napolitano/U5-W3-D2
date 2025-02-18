package it.epicode.__todolist.todolits;

import it.epicode.__todolist.auth.AppUser;
import it.epicode.__todolist.common.CommonReponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public List<TodoResponse> findAll(@AuthenticationPrincipal AppUser user) {
        return todoService.findAll(user);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("isAuthenticated()")
    public CommonReponse save(@RequestBody TodoRequest request, @AuthenticationPrincipal AppUser user) {
        return todoService.save(request, user);
    }

    @DeleteMapping
    @PreAuthorize("isAuthenticated()")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(Long id, @AuthenticationPrincipal AppUser user) {
        todoService.delete(id, user);
    }

}
