import java.util.*;
import java.util.stream.Collectors;
public class TransportService {
    private String companyName;
    private List<Transport> fleet = new ArrayList<>(); // Наш пул данных

    public TransportService(String companyName) {
        this.companyName = companyName;
    }
    public void addVehicle(Transport t) {
        fleet.add(t);
    }
    public void sortByCapacity() {
        fleet.sort(Comparator.comparingInt(Transport::getCapacity));
        System.out.println("Sorted list by capacity");
    }
    public Transport findById(int id) {
        for (Transport t : fleet) {
            if (t.getId() == id) return t;
        }
        return null;
    }
    public List<Transport> getLargeVehicles(int minCapacity) {
        return fleet.stream()
                .filter(t -> t.getCapacity() >= minCapacity)
                .collect(Collectors.toList());
    }
    public List<Transport> getOnlyExpress() {
        return fleet.stream()
                .filter(t -> t instanceof ExpressBus)
                .collect(Collectors.toList());
    }
    public void showFleet() {
        System.out.println("\nCompany: " + companyName);
        for (Transport t : fleet) {
            System.out.println(t);
        }
    }
}
