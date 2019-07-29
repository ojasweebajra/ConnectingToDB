import java.sql.*;
import java.util.Scanner;

public class DBUpdate {

    public static void main(String[] args) {

        String host = "jdbc:mysql://localhost:3306/employees";
        String uName = "root";
        String uPass = "abc@123";
        try {
            Connection conn = DriverManager.getConnection(host, uName, uPass);
            Statement stmt = conn.createStatement();

            Scanner input = new Scanner(System.in);
            System.out.println("Enter the ID you wish to change: ");
            Integer newID = input.nextInt();
            System.out.println("Enter the name you wish to change to: ");
            String newName = input.next();

            String updateSQL = "update workers set First_Name = ? where ID = ?";
            PreparedStatement pstmt = conn.prepareStatement(updateSQL);
            pstmt.setString(1,newName);
            pstmt.setInt(2, newID);

            pstmt.executeUpdate();
//            int rowsaffected = stmt.executeUpdate("update workers" + " set First_Name = newName" + "where ID = newID");
//
//            System.out.println("rows changed: " + rowsaffected);

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

