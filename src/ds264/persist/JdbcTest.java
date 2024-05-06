package ds264.persist;
import java.sql.*;

public class JdbcTest {
    static final String DB_URL = "jdbc:sqlserver://ML-RefVm-231318\\SQLEXPRESS:1433;databaseName=master;encrypt=true;trustServerCertificate=true;";
    static final String USER = "mike";
    static final String PASS = "mike";
    static final String QUERY = "SELECT * FROM accounts";

    public static void main(String[] args) {
        // Open a connection
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY)) {
            // Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                System.out.print("ID: " + rs.getInt("id"));
                System.out.print(", Name: " + rs.getString("name"));
                System.out.print(", Balance: " + rs.getInt("balance"));
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}