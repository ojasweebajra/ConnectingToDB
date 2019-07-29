import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DBDelete {
    public static void main(String[] args) {

        String host = "jdbc:mysql://localhost:3306/employees";
        String uName = "root";
        String uPass = "abc@123";
        try {
            Connection conn = DriverManager.getConnection(host, uName, uPass);
            Statement stmt = conn.createStatement();

            Scanner input = new Scanner(System.in);
            System.out.println("Enter the ID you wish to delete: ");
            Integer delID = input.nextInt();

            String deleteSQL = "delete from workers where id = ?";
            PreparedStatement pstmt = conn.prepareStatement(deleteSQL);
            pstmt.setInt(1,delID);

            pstmt.execute();

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
