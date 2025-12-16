public class Commuter {
    private String name;
    private int age;
    private boolean hasTicket;

    public Commuter(String name, int age, boolean hasTicket) {
        this.name = name;
        this.age = age;
        this.hasTicket = hasTicket;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }

    public void setHasTicket(boolean hasTicket) {
        this.hasTicket = hasTicket;
    }

    public boolean isHasTicket() {
        return hasTicket;
    }

    public String ticketStatus() {
        if (hasTicket) {
            return "бар";
        } else {
            return "жоқ";
        }
    }

    public void info() {
        System.out.println("Жолаушы есімі: " + name + "\n" + ", Жасы: " + age + "\n" + ", Билеті: " + ticketStatus());
    }
}
