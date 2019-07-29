import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.util.Scanner;

public class DBAdd {
    public static void main(String[] args) {

        String host = "jdbc:mysql://localhost:3306/employees";
        String uName = "root";
        String uPass = "abc@123";

        Scanner input = new Scanner(System.in);

        System.out.print("Enter your first name: ");
        String fname = input.next();
        System.out.print("Enter your last name: ");
        String lname = input.next();
        System.out.print("Enter your job title: ");
        String jtitle = input.next();

        try {
            Connection conn = DriverManager.getConnection(host, uName, uPass);
            Statement stmt = conn.createStatement();

            String sqlInsert = "insert into employees.WORKERS " + "(First_Name, Last_Name, Job_Title)" + " values (?,?,?)";
            PreparedStatement preparedStmt = conn.prepareStatement(sqlInsert);
            preparedStmt.setString (1, fname);
            preparedStmt.setString (2, lname);
            preparedStmt.setString   (3, jtitle );

            preparedStmt.execute();

            conn.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
