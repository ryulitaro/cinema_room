package task;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.*;

import java.util.*;
import java.util.concurrent.*;

@RestController
public class Controller {
    final ConcurrentMap<Long, String> items = new ConcurrentHashMap<>(Map.of(
            535L, "Chair",
            99534533L, "Table",
            343455L, "Vase"
    ));

    @GetMapping("/items/{id}")
    String getItem(@PathVariable long id) {
        String item = items.getOrDefault(id, null);
        if (item == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return item;
    }
}
