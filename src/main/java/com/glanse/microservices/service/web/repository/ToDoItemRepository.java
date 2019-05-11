package com.glanse.microservices.service.web.repository;

import com.glanse.microservices.service.web.model.ToDoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoItemRepository extends JpaRepository<ToDoItem, Long> {
}
