import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SeeStaffDailyWork {

    public void SeeStaffDailyWork() {
        System.out.println("|**** Staff's Daily Work ****|");
        String url = "jdbc:mysql://localhost:3306/hostelmanagementsystem";
        String username = "root";
        String password = "rahman__12181";

        String query = """
            SELECT 
                e.staff_EntryID, 
                e.staff_Name, 
                e.date AS EntryDate, 
                e.time AS EntryTime, 
                x.time AS ExitTime
            FROM 
                staffentery e
            INNER JOIN 
                staffexit x
            ON 
                e.staff_EntryID = x.staff_ExitID
            """;

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            // Display result header
            System.out.println("+---------------+---------------+------------+----------+----------+");
            System.out.println("| Staff ID      | Staff Name    | Entry Date | Entry Time | Exit Time |");
            System.out.println("+---------------+---------------+------------+----------+----------+");

            // Fetch and display rows
            while (resultSet.next()) {
                int staffID = resultSet.getInt("staff_EntryID");
                String staffName = resultSet.getString("staff_Name");
                String entryDate = resultSet.getString("EntryDate");
                String entryTime = resultSet.getString("EntryTime");
                String exitTime = resultSet.getString("ExitTime");

                System.out.printf("| %-13d | %-13s | %-10s | %-8s | %-8s |\n",
                                  staffID, staffName, entryDate, entryTime, exitTime);
            }

            System.out.println("+---------------+---------------+------------+----------+----------+");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
