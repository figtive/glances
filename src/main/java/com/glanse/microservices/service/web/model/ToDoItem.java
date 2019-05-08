package com.glanse.microservices.service.web.model;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(schema = "glanse")
public class ToDoItem extends ToDo {

    @Override
    public ToDo addSubToDo(ToDo toDo) {
        ToDoComposite toDoComposite = new ToDoComposite(id, name, done, parentId);
        toDoComposite.setSubToDos(new ArrayList<>());
        toDoComposite.addSubToDo(toDo);
        return toDoComposite;
    }

    @Override
    public void setDone(boolean done) {
        this.done = done;
    }
}
