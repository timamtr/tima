package com.tima;

public class ExpressBus extends Transport {
    public ExpressBus(int id, int capacity, String route) {
        super(id, capacity, route);
    }

    @Override
    public String getTransportType() {
        return "Express bus";
    }
}
