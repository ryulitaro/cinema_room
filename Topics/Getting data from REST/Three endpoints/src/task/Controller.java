package task;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class Controller {
    @GetMapping("/value")
    public int getValue() {
        return 1;
    }

    @GetMapping("text")
    public String getText() {
        return "two";
    }

    @GetMapping("/json")
    public Map getMap() {
        return Map.of("number", 3);
    }
}
