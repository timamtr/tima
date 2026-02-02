package com.tima;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TransportController {
    private final DatabaseManager db = new DatabaseManager();

    @GetMapping("/transports")
    public List<Transport> getTransports() {
        return db.getTransportsFromDB();
    }
}