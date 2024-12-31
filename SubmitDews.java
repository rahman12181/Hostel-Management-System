import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class SubmitDews {

    public void SubmitDews() {
        System.out.println("<------Welcome to Submit Panel------>");

        String url = "jdbc:mysql://localhost:3306/hostelmanagementsystem";
        String username = "root";
        String password = "rahman__12181";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Scanner s = new Scanner(System.in);

            System.out.println("Enter FeeID:");
            int FeeID = s.nextInt();

            System.out.println("Enter Fee_Amount:");
            int Amount = s.nextInt();

            s.nextLine();

            System.out.println("Enter date (yyyy-MM-dd):");
            String date = s.nextLine();

            System.out.println("Enter StudentID:");
            int studentID = s.nextInt();

            String query = "INSERT INTO studentfees(Fee_ID, Fee_Amount, Date, studentID) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
             
                statement.setInt(1, FeeID);
                statement.setInt(2, Amount);
                statement.setString(3, date); 
                statement.setInt(4, studentID);

              
                int queryUpdate = statement.executeUpdate();
                System.out.println("Updated Student Detail. Rows affected: " + queryUpdate);
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
    }
}
