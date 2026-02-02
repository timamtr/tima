package com.tima;

import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DatabaseManager db = new DatabaseManager();
        TransportService cts = new TransportService("City Transportation Systems");
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Public Transport System Menu ---");
            System.out.println("1. Show all transports from DB");
            System.out.println("2. Add new transport to DB");
            System.out.println("3. Search transport by ID (via Service)");
            System.out.println("4. Filter Express routes only (via Service)");
            System.out.println("5. Add new commuter to DB");
            System.out.println("6. Update transport capacity");
            System.out.println("7. Delete transport from DB");
            System.out.println("8. Update commuter ticket status");
            System.out.println("9. Delete commuter from DB");
            System.out.println("0. Exit");
            System.out.print("Choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\n--- Current Fleet in Database ---");
                    db.getAllTransports();
                    break;

                case 2:
                    System.out.print("Enter ID: "); int id = scanner.nextInt();
                    System.out.print("Enter Capacity: "); int cap = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Route: "); String route = scanner.nextLine();
                    System.out.print("Enter Type (Bus/ExpressBus): "); String type = scanner.nextLine();
                    db.addTransport(id, cap, route, type);
                    break;

                case 3:
                    System.out.print("Enter ID to search: ");
                    int searchId = scanner.nextInt();
                    syncServiceWithDB(db, cts);
                    Transport result = cts.findById(searchId);
                    if (result != null) {
                        System.out.println("Found: " + result);
                    } else {
                        System.out.println("No vehicle with ID " + searchId + " found.");
                    }
                    break;

                case 4:
                    syncServiceWithDB(db, cts);
                    System.out.println("\n--- Express Routes (Stream Filter) ---");
                    cts.getOnlyExpress().forEach(System.out::println);
                    break;

                case 5:
                    System.out.print("Name: "); String cName = scanner.nextLine();
                    System.out.print("Age: "); int cAge = scanner.nextInt();
                    System.out.print("Has ticket? (true/false): "); boolean ticket = scanner.nextBoolean();
                    db.addCommuter(cName, cAge, ticket);
                    break;

                case 6:
                    System.out.print("Enter transport ID to update: ");
                    int upId = scanner.nextInt();
                    System.out.print("Enter new capacity: ");
                    int newCap = scanner.nextInt();
                    db.updateCapacity(upId, newCap);
                    break;

                case 7:
                    System.out.print("Enter transport ID to delete: ");
                    int delId = scanner.nextInt();
                    db.deleteTransport(delId);
                    break;

                case 8:
                    System.out.print("Enter commuter ID: ");
                    int cId = scanner.nextInt();
                    System.out.print("Has ticket (true/false): ");
                    boolean tStatus = scanner.nextBoolean();
                    db.updateCommuterTicket(cId, tStatus);
                    break;

                case 9:
                    System.out.print("Enter commuter ID to delete: ");
                    int cDelId = scanner.nextInt();
                    db.deleteCommuter(cDelId);
                    break;

                case 0:
                    running = false;
                    System.out.println("Program terminated.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }

    private static void syncServiceWithDB(DatabaseManager db, TransportService service) {
        List<Transport> fromDB = db.getTransportsFromDB();
        service.getFleet().clear();
        for (Transport t : fromDB) {
            service.addVehicle(t);
        }
        System.out.println("[System] Service synchronized with Database.");
    }
}