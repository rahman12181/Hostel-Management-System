import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class LoginHostel {

public void loginHostel(){
    //THIS METHOD IS SPECIALY FOR USER LOGIN
    
    String url="jdbc:mysql://localhost:3306/hostelmanagementsystem";
    String DBusername="root";
    String DBpassword="rahman__12181";
    
   
    try (Connection connection=DriverManager.getConnection(url, DBusername, DBpassword)) {
        Scanner s=new Scanner(System.in);

        System.out.println("Enter Your Username");
        String Username=s.nextLine();

        System.out.println("Enter Your Password");
        String Password=s.nextLine();
        
        String query="INSERT INTO Logined_user(Username,Password)values(?,?)";
        try(PreparedStatement ststement=connection.prepareStatement(query)){
           
           ststement.setString(1, Username);
           ststement.setString(2, Password);
           int rowInserted=ststement.executeUpdate();
           System.out.println("Logined Sucessfully");
        }

    } catch (SQLException e) {
        
          if (e.getErrorCode()==1062) {
            System.out.println("User Already Exist ");
          }
          else{
            e.getStackTrace();
          }
        
    }
}
}
