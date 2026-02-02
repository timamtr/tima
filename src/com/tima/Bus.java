package com.tima;

public class Bus extends Transport {
    public Bus(int id, int capacity, String route) {
        super(id, capacity, route);
    }

    @Override
    public String getTransportType() {
        return "A regular bus";
    }
}