import java.sql.*;
//import java.util.Scanner;

public class DBConnect {
    public static void main (String []args) {
        //Establish a connection:
        String host = "jdbc:mysql://localhost:3306/employees";
        String uName = "root";
        String uPass = "abc@123";

        try {
            Connection con = DriverManager.getConnection(host, uName, uPass);
            Statement stat = con.createStatement();
            String sql = "select * from workers";
            ResultSet rs = stat.executeQuery(sql);

//            Scanner input = new Scanner(System.in);

//            System.out.print("Enter your first name: ");
//            String fname = input.next();
//            System.out.print("Enter your last name: ");
//            String lname = input.next();
//            System.out.print("Enter your job title: ");
//            String jtitle = input.next();
//
//            String sqlInsert = "insert into employees.WORKERS " + "(First_Name, Last_Name, Job_Title)" + " values (?,?,?)";

//            PreparedStatement pstmt = con.executeUpdate(sqlInsert);

            while (rs.next()) {
                int id_col = rs.getInt("ID");
                String first_name = rs.getString("First_Name");
                String last_name = rs.getString("Last_Name");
                String job = rs.getString("Job_Title");

                String p = id_col + " " + first_name + " " + last_name + " " + job;
                System.out.println(p);
            }

        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }
}
