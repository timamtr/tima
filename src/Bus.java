public class Bus {
    private int busNumber;
    private int capacity;
    private String route;

    public Bus(int busNumber, int capacity, String route){
        this.busNumber = busNumber;
        this.capacity = capacity;
        this.route = route;
    }

    public void setBusNumber(int busNumber) {
        this.busNumber = busNumber;
    }
    public int getBusNumber() {
        return busNumber;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public int getCapacity() {
        return capacity;
    }

    public void setRoute(String route) {
        this.route = route;
    }
    public String getRoute() {
        return route;
    }

    public void info() {
        System.out.println("Автобус нөмірі: " + busNumber +"\n"
                + "Сыйымдылығы: " + capacity + "\n"
                + "Жүру бағыты: " + route);
    }
}

