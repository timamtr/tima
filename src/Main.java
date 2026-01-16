public class Main {
    public static void main(String[] args) {
        DatabaseManager db = new DatabaseManager();


        db.addTransport(10, 50, "Astana1 - Airport", "Bus");
        db.addTransport(502, 45, "Bagystan TK - Astana1", "ExpressBus");
        db.addTransport(15, 60, "Arnau TK - Zheleznodorozhnyi", "Bus");

        db.addCommuter("Tima", 18, true);
        db.addCommuter("Sanzhar", 17, false);

        System.out.println("Succesfull");


        db.getAllTransports();
    }
}