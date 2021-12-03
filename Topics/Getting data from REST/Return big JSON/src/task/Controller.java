package task;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class Controller {
    List<Map<String, Object>> colors = List.of(
            Map.of("color", "black",
                    "category", "hue",
                    "type", "primary",
                    "code", Map.of("rgba", Arrays.asList(0, 0, 0, 1), "hex", "#000")),
            Map.of("color", "white",
                    "category", "value",
                    "type", "primary",
                    "code", Map.of("rgba", Arrays.asList(255, 255, 255, 1), "hex", "#FFF"))
    );


    @GetMapping("/colors")
    public Map<String, List<Map<String, Object>>> getColors() {
        return Map.of("colors", colors);
    }
}