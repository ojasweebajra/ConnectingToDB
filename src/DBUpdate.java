import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUpdate {

    public static void main(String[] args) {

        String host = "jdbc:mysql://localhost:3306/employees";
        String uName = "root";
        String uPass = "abc@123";
        try {
            Connection conn = DriverManager.getConnection(host, uName, uPass);
            Statement stmt = conn.createStatement();
            int rowsaffected = stmt.executeUpdate("update workers" + " set First_Name = 'Ojaswee'" + "where ID = 7");

            System.out.println("rows changed: " + rowsaffected);

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

