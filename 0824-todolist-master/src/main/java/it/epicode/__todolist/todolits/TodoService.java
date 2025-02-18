package it.epicode.__todolist.todolits;

import it.epicode.__todolist.auth.AppUser;
import it.epicode.__todolist.auth.AppUserService;
import it.epicode.__todolist.common.CommonReponse;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;
    private final AppUserService appUserService;

    public List<TodoResponse> findAll(AppUser appUser) {
        return fromTodos(todoRepository.findAllByAppUser(appUser));
    }

    public CommonReponse save(@Valid TodoRequest request, AppUser appUser) {
        Todo todo = new Todo();
        BeanUtils.copyProperties(request, todo);
        todo.setAppUser(appUser);
        todoRepository.save(todo);
        return new CommonReponse( todo.getId());
    }


    public void delete(Long id, AppUser appUser) {
        if(!todoRepository.existsById(id)){
            throw new EntityNotFoundException( "Todo non trovato");
        }
        Todo todo = todoRepository.findById(id).get();
        if(todo.getAppUser().getId() != appUser.getId()){
            throw new AccessDeniedException("Non puoi cancellare un todo che non ti appartiene");
        }
        todoRepository.delete(todo);
    }

    public List<TodoResponse> fromTodos(List<Todo> todos) {
        return todos.stream()
                .map(this::fromTodo)
                .toList();
    }

    public TodoResponse fromTodo(Todo todo) {
        TodoResponse todoResponse = new TodoResponse();
        BeanUtils.copyProperties(todo, todoResponse);
        return todoResponse;
    }


}
