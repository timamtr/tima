import java.util.Objects;

public abstract class Transport {
    private int id;
    private int capacity;
    private String route;

    public Transport(int id, int capacity, String route) {
        this.id = id;
        this.capacity = capacity;
        this.route = route;
    }

    public abstract String getTransportType();

    public int getId() { return id; }
    public String getRoute() { return route; }
    public int getCapacity() { return capacity; }

    @Override
    public String toString() {
        return String.format("%s №%d [Route: %s, Capacity: %d]",
                getTransportType(), id, route, capacity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return id == transport.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
