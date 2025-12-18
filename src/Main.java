//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Bus bus1 = new Bus(10, 50, "Астана1 - Әуежай");
        Bus bus2 = new Bus(26, 40, "Бағыстан ТК - Конституция көшесі");
        Bus bus3 = new Bus(15, 40, "ЖК Арнау - ж|м Железнодорожный");

        Commuter commuter1 = new Commuter("Темірлан", 18, true);
        Commuter commuter2 = new Commuter("Санжар", 17, false);

        TransportService transportService1 = new TransportService("ТОО City Transportation Systems");

        bus1.info();
        bus2.info();
        bus3.info();

        commuter1.info();
        commuter2.info();

        transportService1.info();

        System.out.println("Объект жасалды!");
        if (commuter1.getAge() > commuter2.getAge()) {
            System.out.println("1-ші жолаушының жасы үлкен");
        } else if (commuter1.getAge() == commuter2.getAge()) {
            System.out.println("Екі жолаушының жасы бірдей");
        } else {
            System.out.println("2-ші жолаушының жасы үлкен");
        }
    }
}
