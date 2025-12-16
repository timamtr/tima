public class TransportService {
    private String serviceName;

    public TransportService(String serviceName) {
        this.serviceName = serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void info() {
        System.out.println("Транспорт сервисі: " + serviceName);
    }
}
