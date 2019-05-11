package com.glanse.microservices.service.web.controller;

import com.glanse.microservices.service.web.model.ToDo;
import com.glanse.microservices.service.web.model.ToDoComposite;
import com.glanse.microservices.service.web.model.ToDoItem;
import com.glanse.microservices.service.web.repository.ToDoCompositeRepository;
import com.glanse.microservices.service.web.repository.ToDoItemRepository;
import com.glanse.microservices.service.web.repository.ToDoRepository;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class ToDoRestController {

    private final ToDoCompositeRepository toDoCompositeRepository;
    private final ToDoItemRepository toDoItemRepository;
    private final ToDoRepository toDoRepository;

    public ToDoRestController(ToDoCompositeRepository toDoCompositeRepository, ToDoItemRepository toDoItemRepository, ToDoRepository toDoRepository) {
        this.toDoCompositeRepository = toDoCompositeRepository;
        this.toDoItemRepository = toDoItemRepository;
        this.toDoRepository = toDoRepository;
    }
}