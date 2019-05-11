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
    @GetMapping("/todo/setdone")
    public ToDo setToDoDone(@RequestParam(name = "id") Long id, @RequestParam(name = "done") boolean done) {
        Optional<ToDo> toDoOptional = toDoRepository.findById(id);
        if (toDoOptional.isPresent()) {
            ToDo toDo = toDoOptional.get();
            toDo.setDone(done);
            return toDoRepository.save(toDo);
        }
        throw new EntityNotFoundException(id.toString());
    }
    @PostMapping("/todo/item/post")
    public ToDoItem postToDoItem(@RequestBody ToDoItem toDoItem) {
        return toDoItemRepository.save(toDoItem);
    }

    @PostMapping("/todo/item/postbatch")
    public List<ToDoItem> postToDoItemBatch(@RequestBody List<ToDoItem> toDoItems) {
        return toDoItemRepository.saveAll(toDoItems);
    }

    @GetMapping("/todo/item/get")
    public List<ToDoItem> getToDoItems() {
        return toDoItemRepository.findAll();
    }

    @PostMapping("/todo/item/addsub")
    public ToDo addSubToDo2Item(@RequestBody ToDo toDo) {
        Optional<ToDo> toDoOptional = toDoRepository.findById(toDo.getParentId());
        if (toDoOptional.isPresent()) {
            ToDo parent = toDoOptional.get();
            ToDo newParent = parent.addSubToDo(toDo);
            toDoRepository.delete(parent);
            return toDoRepository.save(newParent);
        }
        throw new EntityNotFoundException(toDo.getName() + " " + toDo.getId());
    }

    @PostMapping("/todo/composite/post")
    public ToDoComposite postToDoComposite(@RequestBody ToDoComposite toDoComposite) {
        return toDoCompositeRepository.save(toDoComposite);
    }

    @PostMapping("/todo/composite/postbatch")
    public List<ToDoComposite> postToDoCompositeBatch(@RequestBody List<ToDoComposite> toDoComposites) {
        return toDoCompositeRepository.saveAll(toDoComposites);
    }

    @GetMapping("/todo/composite/get")
    public List<ToDoComposite> getToDoComposites() {
        return toDoCompositeRepository.findAll();
    }

    @GetMapping("/todo/composite/getroot")
    public List<ToDoComposite> getToDoComposite() {
        return toDoCompositeRepository.findAllByParentId(null);
    }


}