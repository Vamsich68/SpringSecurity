package com.SpringSecurity.SpringSecurity.helloworldResources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

record Todo (String username, String description){}
@RestController
public class ToDoResource {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @GetMapping("/todos")
    public List<Todo> retrieveLLTodos(){
        return List.of(new Todo("vamsi","aws"), new Todo("vamsi","azure"));
    }
    @PostMapping("/users/{username}/todos")
    public void createTodoForSpecificUser(@PathVariable String username
            , @RequestBody Todo todo) {
        logger.info("Create {} for {}", todo, username);
    }

}

