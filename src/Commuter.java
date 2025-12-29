import java.util.Objects;

public class Commuter {
    private String name;
    private int age;
    private boolean hasTicket;

    public Commuter(String name, int age, boolean hasTicket) {
        this.name = name;
        this.age = age;
        this.hasTicket = hasTicket;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public boolean isHasTicket() { return hasTicket; }
    public void setHasTicket(boolean hasTicket) { this.hasTicket = hasTicket; }

    @Override
    public String toString() {
        return String.format("Passenger: %s, Age: %d, Ticket: %s",
                name, age, (hasTicket ? "Yes" : "No"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commuter commuter = (Commuter) o;
        return age == commuter.age && Objects.equals(name, commuter.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}