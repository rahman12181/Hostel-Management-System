import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class RemoveStaff {

    public void removeStaff() {
        String url = "jdbc:mysql://localhost:3306/hostelmanagementsystem";
        String username = "root";
        String password = "rahman__12181";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Scanner s = new Scanner(System.in);
            System.out.println("Enter Staff ID:");
            int stafID = s.nextInt();
            s.nextLine(); // Consume newline

            System.out.println("Enter Staff Name:");
            String staff_Name = s.nextLine();

            // Correct table name and column names
            String query = "DELETE FROM stafinformation WHERE stafID = ? AND staff_Name = ?";
           

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, stafID);
                statement.setString(2, staff_Name);

                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Staff successfully removed.");
                } else {
                    System.out.println("No staff found with the provided details.");
                }
            }

        } catch (SQLException e) {
            System.out.println("Error while connecting to the database or executing the query:");
            e.printStackTrace();
        }
    }
}