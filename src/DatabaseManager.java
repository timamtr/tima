import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private static final String URL = "jdbc:postgresql://localhost:5432/your_db_name";
    private static final String USER = "postgres";
    private static final String PASSWORD = "your_password";

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void addTransport(int id, int capacity, String route, String type) {
        String sql = "INSERT INTO transports(id, capacity, route, type) VALUES(?, ?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setInt(2, capacity);
            pstmt.setString(3, route);
            pstmt.setString(4, type);
            pstmt.executeUpdate();
            System.out.println("Data inserted successfully!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getAllTransports() {
        String sql = "SELECT * FROM transports";
        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" +
                        rs.getInt("capacity") + "\t" +
                        rs.getString("route") + "\t" +
                        rs.getString("type"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateCapacity(int id, int newCapacity) {
        String sql = "UPDATE transports SET capacity = ? WHERE id = ?";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, newCapacity);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            System.out.println("Data updated!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteTransport(int id) {
        String sql = "DELETE FROM transports WHERE id = ?";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Data deleted!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void addCommuter(String name, int age, boolean hasTicket) {
        String sql = "INSERT INTO commuters(name, age, has_ticket) VALUES(?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setBoolean(3, hasTicket);
            pstmt.executeUpdate();
            System.out.println("Passenger " + name + " added!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
