import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.management.Query;

public class ViewAssignedRoom {

    public void viewAssignedRoom(){
        System.out.println("<-----View Your Assigned Room----->");
        
        String url="jdbc:mysql://localhost:3306/HostelManagementSystem";
        String username="root";
        String password="rahman__12181";

        try (Connection connection=DriverManager.getConnection(url, username, password)) {
            Scanner s=new Scanner(System.in);
            System.out.println("Enter Student Name:")        ;
            String studentName=s.nextLine();
            System.out.println("Enter StudentID:");
            int studentID=s.nextInt();
            String query="SELECT * FROM studentrooms WHERE studentName=? AND studentID=?";
               try(PreparedStatement statement=connection.prepareStatement(query)){
                   
                statement.setString(1, studentName);
                statement.setInt(2, studentID);
                ResultSet resultSet=statement.executeQuery();
                boolean hasResults = false;
                while (resultSet.next()) {
                    hasResults = true;
                    System.out.println("<-------********************-------->");
                    System.out.println("Room Number: " + resultSet.getInt("allotedRoom"));
                    System.out.println("studentName: " + resultSet.getString("studentName"));
                    System.out.println("<-------********************-------->"); // Replace with your column names
                }
                
                if (!hasResults) {
                    System.out.println("No room assigned for the given student.");
                }

               }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
