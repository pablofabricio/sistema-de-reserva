package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBDCConnection {

    public static Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3303/reserva?useTimezone=true&serverTimezone=UTC&useSSL=false";
            String username = "root";
            String password = "Root@1234567";
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
 }
