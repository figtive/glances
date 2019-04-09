package myHomepage.controller;

import myHomepage.model.Student;
import myHomepage.repository.StudentRepository;
import org.hibernate.ObjectNotFoundException;
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

    @Autowired
    public DevController(StudentRepository repository) {
        this.studentRepository = repository;
    }

    @GetMapping("/jpasave")
    public Student jpaSaveStudent(@RequestParam(name = "name") String name, @RequestParam(name = "address", required = false) String address) {
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
