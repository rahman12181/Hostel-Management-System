import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AddStaff {

    public void addStaf(){
        String url="jdbc:mysql://localhost:3306/hostelmanagementsystem";
        String username="root";
        String password="rahman__12181";

        try (Connection connection=DriverManager.getConnection(url, username, password)) {
            Scanner s=new Scanner(System.in);
            System.out.println("Enter Staff ID:");
            int stafID=s.nextInt();
            s.nextLine();
            System.out.println("Enter Staff Name:");
            String staff_Name=s.nextLine();
            System.out.println("Enter Staff Current Address:");
            String Address=s.nextLine();
            System.out.println("Enter staf Work:");
            String staf_Work=s.nextLine();

           String query="INSERT INTO Stafinformation(stafID,staff_Name,Address,staf_Work)VALUES(?,?,?,?)";
           try(PreparedStatement statement=connection.prepareStatement(query)){
                statement.setInt(1, stafID);
                statement.setString(2, staff_Name);
                statement.setString(3, Address);
                statement.setString(4, staf_Work);
                int exicutequery=statement.executeUpdate();
                System.out.println("Updated Staff Information Successfully.."+exicutequery);
           }
            
        } catch (SQLException e) {
           if (e.getErrorCode()==1062) {
              System.out.println("Staff Already Exist..");
           }
           e.getStackTrace();
        }
    }
}
