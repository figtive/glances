package com.glanse.microservices.service.web.repository;

import com.glanse.microservices.service.web.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long> {

    List<ToDo> findAllByParentId(Long parentId);
}
