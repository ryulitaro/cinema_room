package task;

import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.*;

@RestController
public class Controller {
    private Queue<String> users = new ConcurrentLinkedQueue<>();

    @PostMapping("/users")
    public void addUser(@RequestParam String name) {
        users.add(name);
    }

    @GetMapping("/users")
    public Queue<String> getUsers() {
        return users;
    }

}
