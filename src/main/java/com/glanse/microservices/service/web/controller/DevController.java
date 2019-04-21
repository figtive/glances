package com.glanse.microservices.service.web.controller;

import com.glanse.microservices.service.web.model.Student;
import com.glanse.microservices.service.web.repository.StudentRepository;
import org.hibernate.ObjectNotFoundException;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * This controller are for development purpose only
 */
@RestController
public class DevController {

    private final StudentRepository studentRepository;

//    private final SessionFactory sessionFactory;

    @Autowired
    public DevController(StudentRepository repository) {
//    public DevController(StudentRepository repository, SessionFactory sessionFactory) {
        this.studentRepository = repository;
//        this.sessionFactory = sessionFactory;
    }

    @GetMapping("/jpasave")
    public Student jpaSaveStudent(@RequestParam(name = "name") String name, @RequestParam(name = "address", required = false) String address) {
//        Session session = sessionFactory.getCurrentSession();
//        session.getTransaction().begin();
//        Student out = studentRepository.save(new Student(name, address));
//        session.getTransaction().commit();
//        return out;
        return studentRepository.save(new Student(name, address));
    }

    @GetMapping("/jpaget")
    public Student jpaGetStudent(@RequestParam(name = "id") Long id) {
        if (studentRepository.findById(id).isPresent()) {
            return studentRepository.findById(id).get();
        }
        throw new ObjectNotFoundException(id, "Student");
    }
}
