package com.tima;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/transports")
public class TransportController {

    private final DatabaseManager db = new DatabaseManager();

    @GetMapping
    public List<Transport> getTransports() {
        return db.getTransportsFromDB();
    }


    @PostMapping
    public void addTransport(@RequestBody TransportRequest request) {

        int randomId = (int) (System.currentTimeMillis() % 100000);


        db.addTransport(randomId, request.capacity, request.route, request.type);
    }


    @DeleteMapping("/{id}")
    public void deleteTransport(@PathVariable int id) {
        db.deleteTransport(id);
    }


    static class TransportRequest {
        public String type;
        public String route;
        public int capacity;
    }
}