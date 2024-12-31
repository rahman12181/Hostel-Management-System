import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class CheakDews {
   
    public void cheakDews(){
       

        String url="jdbc:mysql://localhost:3306/hostelmanagementsystem";
        String username="root";
        String password="rahman__12181";

        try (Connection connection=DriverManager.getConnection(url, username, password)) {
            Scanner s=new Scanner(System.in);
            System.out.println("For Fees Submitting Enter Student information:");
            System.out.println("Enter studenID:");
            int studentID=s.nextInt();
             String query="select studentrooms.studentID,studentrooms.studentName,studentrooms.allotedRoom,studentfees.Fee_Amount,studentfees.Date from studentrooms left join studentfees on studentrooms.studentID=studentfees.studentID where studentrooms.studentID=? ";
             try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, studentID);

                // Use executeQuery for SELECT statements
                try (ResultSet resultSet = statement.executeQuery()) {
                    boolean hasResults = false;
                    while (resultSet.next()) {
                        hasResults = true;
                        // Fetch and print the data
                        int id = resultSet.getInt("studentID");
                        String name = resultSet.getString("studentName");
                        String room = resultSet.getString("allotedRoom");
                        double fee = resultSet.getDouble("Fee_Amount");
                        boolean isFeeNull = resultSet.wasNull();
                        Date date = resultSet.getDate("Date");
                        String feeStatus = isFeeNull ? "Dues Pending" : "No Dues";
                        System.out.println("Student ID: " + id);
                        System.out.println("Student Name: " + name);
                        System.out.println("Alloted Room: " + room);
                        System.out.println("Fee Amount: " + fee);
                        System.out.println("Fee Status: " + feeStatus);
                        System.out.println("Fee Submission Date: " + date);
                        System.out.println("----------------------------------");
                    }
                    if (!hasResults) {
                        System.out.println("No data found for the given Student ID.");
                    }
                }
            }

        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
    }
    }

