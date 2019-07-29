import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBDelete {
    public static void main(String[] args) {

        String host = "jdbc:mysql://localhost:3306/employees";
        String uName = "root";
        String uPass = "abc@123";
        try {
            Connection conn = DriverManager.getConnection(host, uName, uPass);
            Statement stmt = conn.createStatement();
            int rowsaffected = stmt.executeUpdate("delete from workers" + "where First_Name = 'Ojaswee'");

            System.out.println("rows changed: " + rowsaffected);

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
