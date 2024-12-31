import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class RequestRoomChange {

    public void requestroomChange(){
        
        System.out.println("<------Welcome to Request Pannel------>");
        String url="jdbc:mysql://localhost:3306/HostelManagementSystem";
        String username="root";
        String password="rahman__12181";

        try (Connection connection=DriverManager.getConnection(url, username, password)) {
            Scanner s=new Scanner(System.in);
            System.out.println("Enter Your StudentID:");
            int studentID=s.nextInt();
            s.nextLine();
            System.out.println("Enter Your Name:");
            String name=s.nextLine();
            System.out.println("Your Problem Request:");
            String request=s.nextLine();
            String query="INSERT INTO RoomChangeRequest(studentID,studentName,Request)VALUES(?,?,?)";
            try(PreparedStatement statement=connection.prepareStatement(query)){
                
                statement.setInt(1, studentID);
                statement.setString(2,name);
                statement.setString(3, request);
                int exicuteQuery=statement.executeUpdate();
                System.out.println("request sent"+"\nthank you");
            }

        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
