package com.glanse.microservices.service.web.repository;

import com.glanse.microservices.service.web.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {}
