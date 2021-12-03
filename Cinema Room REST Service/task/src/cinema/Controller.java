package cinema;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@RestController
public class Controller {
    final int ROW = 9;
    final int COLUMNS = 9;

    private ConcurrentMap<String, String> purchaseMap = new ConcurrentHashMap<>();
    private ConcurrentMap<String, Seat> tokenMap = new ConcurrentHashMap<>();

    @GetMapping("/seats")
    public Map<String, Object> getSeats() {
        List<Seat> seats = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                seats.add(new Seat(i, i));
            }
        }
        return Map.of("total_rows", ROW,
                "total_columns", COLUMNS,
                "available_seats", seats);
    }

    @PostMapping("/purchase")
    public ResponseEntity<Map<String, Object>> purchase(@RequestBody Seat seat) {
        int row = seat.getRow();
        int column = seat.getColumn();
        if (row > 9 || column > 9 || row < 1 || column < 1) {
            return returnError("The number of a row or a column is out of bounds!", HttpStatus.BAD_REQUEST);
        }
        String index = row + "_" + column;
        if (purchaseMap.containsKey(index)) {
            return returnError("The ticket has been already purchased!", HttpStatus.BAD_REQUEST);
        }

        UUID uuid = UUID.randomUUID();
        synchronized (this) {
            purchaseMap.put(index, uuid.toString());
            tokenMap.put(uuid.toString(), seat);
        }
        return returnOk(Map.of(
                "token", uuid.toString(),
                "ticket", seat
        ));
    }

    @PostMapping("/return")
    public ResponseEntity<Map<String, Object>> returnTicket(@RequestBody Map<String, String> tokenInput) {
        String token = tokenInput.get("token");
        if (token == null) {
            return returnError("Wrong token!", HttpStatus.BAD_REQUEST);
        }
        synchronized (this) {
            Seat seat = tokenMap.remove(token);
            if (seat != null) {
                String index = seat.getRow() + "_" + seat.getColumn();
                purchaseMap.remove(index);
                return returnOk(Map.of(
                        "returned_ticket", seat));
            }
        }
        return returnError("Wrong token!", HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/stats")
    public ResponseEntity<Map<String, Object>> stats(@RequestParam(value = "password", required = false) String password) {
        if (password != null && password.equals("super_secret")) {
            int income = 0;
            synchronized (this) {
                for (Seat seat : tokenMap.values()) {
                    income += seat.getPrice();
                }
            }
            int number_of_purchased_tickets = tokenMap.size();
            int number_of_available_seats = ROW * COLUMNS - number_of_purchased_tickets;
            return returnOk(Map.of(
                    "current_income", income,
                    "number_of_available_seats", number_of_available_seats,
                    "number_of_purchased_tickets", number_of_purchased_tickets
            ));
        }
        return returnError("The password is wrong!", HttpStatus.UNAUTHORIZED);
    }

    ResponseEntity<Map<String, Object>> returnError(String message, HttpStatus status) {
        return new ResponseEntity<>(Map.of(
                "error", message
        ), status);
    }

    ResponseEntity<Map<String, Object>> returnOk(Map<String, Object> response) {
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
