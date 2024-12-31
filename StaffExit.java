import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class StaffExit {

    public void stafExit() {
        String url = "jdbc:mysql://localhost:3306/hostelmanagementsystem";
        String username = "root";
        String password = "rahman__12181";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Scanner s = new Scanner(System.in);

            System.out.println("Enter StaffID:");
            int staff_ExitID = s.nextInt();
            s.nextLine(); // Clear buffer
            System.out.println("Enter Staff_Name:");
            String staff_Name = s.nextLine();
            System.out.println("Enter Exit Time (format HH:mm):");
            String time = s.nextLine();

            String query = "INSERT INTO StaffExit (staff_ExitID, staff_Name, time) VALUES (?, ?, ?)";

           
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, staff_ExitID);
                statement.setString(2, staff_Name);
                statement.setString(3, time); // Fixed index here

                int queryExecute = statement.executeUpdate();
                System.out.println("Staff Exit Successful.  " + queryExecute);
            }
        } catch (SQLException e) {
            if (e.getErrorCode() == 1062) {
                System.out.println("Staff Already Exited.");
            } else {
                e.printStackTrace();
            }
        }
    }
}
