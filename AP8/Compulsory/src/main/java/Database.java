import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/lab8";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";
    private static Connection connection = null;

    private Database() {
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            createConnection();
        }
        return connection;
    }

    private static void createConnection() throws SQLException {
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
        connection.setAutoCommit(false);
    }

    public static void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    public static void rollback() {
        try {
            if (connection != null) {
                connection.rollback();
            }
        } catch (SQLException e) {
            System.err.println("Failed to rollback: " + e.getMessage());
        }
    }
}
