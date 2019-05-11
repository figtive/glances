package com.glanse.microservices.service.web.repository;

import com.glanse.microservices.service.web.model.ToDoComposite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoCompositeRepository extends JpaRepository<ToDoComposite, Long> {

    List<ToDoComposite> findAllByParentId(Long parentId);
}
