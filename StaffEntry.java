import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.time.LocalDateTime;

public class StaffEntry {
 
    public void stafentry(){
        String url="jdbc:mysql://localhost:3306/hostelmanagementsystem";
        String username="root";
        String password="rahman__12181";

       try (Connection connection=DriverManager.getConnection(url, username, password)) {
            Scanner s=new Scanner(System.in);
            System.out.println("Enter StaffID:");
            int staff_EntryID=s.nextInt();
            s.nextLine();
            System.out.println("Enter Staff_Name");
            String staff_Name=s.nextLine();
            System.out.println("Entery Date:(format yyyy-mm-d)");
            String date=s.nextLine();
            System.out.println("Enter Entry Time:");
            String time=s.nextLine();
            String query="INSERT INTO StaffEntery(staff_EntryID,staff_Name,date,time)values(?,?,?,?)";
            try(PreparedStatement statement=connection.prepareStatement(query)){
                 statement.setInt(1, staff_EntryID);
                 statement.setString(2, staff_Name);
                 statement.setString(3, date);
                 statement.setString(4, time);
                 int queryExicute=statement.executeUpdate();
                 System.out.println("Staff Entry Sucessfull.."+queryExicute);
            }
       } catch (SQLException e) {
        if (e.getErrorCode()==1062) {
            System.out.println("Staff Alrady Entered..");
        }
        e.getStackTrace();
       }
    }

}

