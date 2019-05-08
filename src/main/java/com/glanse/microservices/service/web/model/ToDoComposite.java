package com.glanse.microservices.service.web.model;

import javax.persistence.*;
import java.util.List;

@SuppressWarnings("unused")
@Entity
@Table(schema = "glanse")
public class ToDoComposite extends ToDo {

    @Column
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "todo_id")
    private List<ToDo> subToDos = null;

    public ToDoComposite() {}

    ToDoComposite(Long id, String name, boolean done, Long parent) {
        this.id = id;
        this.name = name;
        this.done = done;
        this.parentId = parent;
    }

    public List<ToDo> getSubToDos() {
        return subToDos;
    }

    public void setSubToDos(List<ToDo> subToDos) {
        this.subToDos = subToDos;
    }

    @Override
    public void setDone(boolean done) {
        this.done = done;
        for (ToDo toDo : this.subToDos) {
            toDo.setDone(done);
        }
    }

    @Override
    public ToDo addSubToDo(ToDo subToDo) {
        this.subToDos.add(subToDo);
        return this;
    }
}
