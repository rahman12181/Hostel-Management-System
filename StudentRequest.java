import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentRequest {
   
    public void studentREquest(){
        String url="jdbc:mysql://localhost:3306/HostelManagementSystem";
        String username="root";
        String password="rahman__12181";

        try (Connection connection=DriverManager.getConnection(url, username, password)) {
            String query="Select * from roomchangerequest";
            try(PreparedStatement statement=connection.prepareStatement(query)){
                 ResultSet resultSet=statement.executeQuery();
                
                 while (resultSet.next()) {
                    System.out.println("<-------********************-------->");
                    System.out.println("StudentID: " + resultSet.getInt("studentID"));
                    System.out.println("studentName: " + resultSet.getString("studentName"));
                    System.out.println("Request: " + resultSet.getString("Request"));
                    System.out.println("<-------********************-------->");
                }
                
              
            }
            
        } catch (Exception e) {
            
        }
    }
}
