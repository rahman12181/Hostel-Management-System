import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StafsInformation {

    public void stafsInformation(){
           System.out.println("|***Stafs Information***|");
       

        String url = "jdbc:mysql://localhost:3306/hostelmanagementsystem";
        String username = "root";
        String password = "rahman__12181";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // SQL query to fetch all data
            String query = "SELECT * FROM stafinformation";

            // Using Statement to execute the query
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {

                // Print table header
                System.out.println("+--------+--------------------+-----------------------+--------------+");
                System.out.println("| stafID | staff_Name         | Address               | staf_Work    |");
                System.out.println("+--------+--------------------+-----------------------+--------------+");

                // Loop through the result set and display data
                while (resultSet.next()) {
                    int stafID = resultSet.getInt("stafID");
                    String staffName = resultSet.getString("staff_Name");
                    String address = resultSet.getString("Address");
                    String stafWork = resultSet.getString("staf_Work");

                    System.out.printf("| %6d | %-18s | %-21s | %-12s |\n",
                            stafID, staffName, address, stafWork);
                }

                System.out.println("+--------+--------------------+-----------------------+--------------+");
            }

        } catch (SQLException e) {
            System.out.println("Error while connecting to the database or fetching data:");
            e.printStackTrace();
        }
    }

    }

