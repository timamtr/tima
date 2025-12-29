public class Main {
    public static void main(String[] args) {
        TransportService cts = new TransportService("City Transportation Systems");

        cts.addVehicle(new Bus(10, 50, "Astana1 - Airport"));
        cts.addVehicle(new ExpressBus(502, 45, "Bagystan TK - Astana1"));
        cts.addVehicle(new Bus(15, 60, "Arnau TK - Zheleznodorozhnyi"));

        cts.showFleet();

        cts.sortByCapacity();
        cts.showFleet();

        System.out.println("\nSearch result №10 " + cts.findById(10));

        System.out.println("\nExpress routes only:");
        cts.getOnlyExpress().forEach(System.out::println);
    }
}