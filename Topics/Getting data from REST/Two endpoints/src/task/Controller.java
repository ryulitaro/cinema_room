package task;

import org.springframework.web.bind.annotation.*;

import java.util.*;

class Student {
    private final int id;
    private final String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

@RestController
public class Controller {
    List<Student> students = List.of(
            new Student(84, "Alice"),
            new Student(99, "Kate"),
            new Student(55, "someone")
    );

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id) {
        switch (id) {
            case 84:
                return students.get(0);
            case 99:
                return students.get(1);
            case 55:
                return students.get(2);
            default:
                return null;
        }
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }
}
