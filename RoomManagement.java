import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.x.protobuf.MysqlxCrud.Insert;

public class RoomManagement {

 
       class Room {
      
            int roomNumber;
            boolean isOccupied;
            public Room(int roomNumber){
               this.roomNumber=roomNumber;
               this.isOccupied=false;
            } 
            
            public void roomAllocate(){

                String url="jdbc:mysql://localhost:3306/hostelmanagementsystem";
                String username="root";
                String password="rahman__12181";

                
                try (Connection connection=DriverManager.getConnection(url, username, password)) {
                    Scanner s=new Scanner(System.in);
                    System.out.println("Enter StudentID:");
                    int studentID=s.nextInt();
                    s.nextLine();
                    System.out.println("Enter Student Name:");
                    String studentName=s.nextLine();
                    System.out.println("Enter your Email:");
                    String studentEmail=s.nextLine();
                    System.out.println("Enetr RoomNumber:");
                    int allotedRoom=s.nextInt();
    
                    if (!isOccupied) {
                      isOccupied=true;
                      System.out.println("Room"+roomNumber+"Occupied Successfully");
                    }
                    else{
                      System.out.println("Room"+roomNumber+"Is Already Occupied");
                    }
                    String query="INSERT INTO studentrooms(studentID,studentName,studentEmail,allotedRoom)values(?,?,?,?)";
                    try(PreparedStatement statement=connection.prepareStatement(query)){

                          statement.setInt(1, studentID);
                          statement.setString(2, studentName);
                          statement.setString(3, studentEmail);
                          statement.setInt(4, allotedRoom);
                          int rowInserted=statement.executeUpdate();
                          System.out.println("RoomAllocated Sucessfully");
                    }
                } catch (SQLException e) {
                    if (e.getErrorCode()==1062) {
                        System.out.println("Student Already Registered");
                    }
                    else{
                        e.getStackTrace();
                    }
                }
               
            }
            public void vacateRoom(){
                Scanner s=new Scanner(System.in);
                String url="jdbc:mysql://localhost:3306/hostelmanagementsystem";
                String username="root";
                String password="rahman__12181";

                try (Connection connection=DriverManager.getConnection(url, username, password)) {
                  
                    System.out.println("Enter StudentID:");
                    String removestudentID=s.nextLine();

                    if (isOccupied) {
                        isOccupied=false;
                        System.out.println("Room"+roomNumber+"Is now Vacant");
                  }
                  else{
                        System.out.println("Room"+roomNumber+"Is Already Vacant");
                  }
                    String query="DELETE FROM studentrooms where studentID=?";
                    try(PreparedStatement statement=connection.prepareStatement(query)){
                        
                     statement.setString(1, removestudentID);
                     int studentremoved=statement.executeUpdate();
                         System.out.println("removed Student Succesfully"+studentremoved);
                    }
                } catch (SQLException e) {
                    if (e.getErrorCode()==1062) {
                        System.out.println("Student Found");
                        
                    }
                
                }
                  
            }
      }

public void roomManagement(){
 
        Scanner scanner = new Scanner(System.in);

        // Create rooms
        Room[] rooms = new Room[50]; // Array for 50 rooms
        for (int i = 0; i < rooms.length; i++) {
            rooms[i] = new Room(i + 1);
        }

        while (true) {
            System.out.println("\nHostel RoomManagement");
            System.out.println("1. Check room availability");
            System.out.println("2. Allot a room");
            System.out.println("3. Vacate a room");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Room Availability:");
                    for (Room room : rooms) {
                        String status = room.isOccupied ? "Occupied" : "Empty";
                        System.out.println("Room " + room.roomNumber + ": " + status);
                    }
                    break;
                case 2:
                    System.out.print("Enter room number to allot (1-50): ");
                    int roomToAllot = scanner.nextInt();
                    if (roomToAllot > 0 && roomToAllot <= rooms.length) {
                        rooms[roomToAllot - 1].roomAllocate();
                    } else {
                        System.out.println("Invalid room number.");
                    }
                    break;
                case 3:
                    System.out.print("Enter room number to vacate (1-50): ");
                    int roomToVacate = scanner.nextInt();
                    if (roomToVacate > 0 && roomToVacate <= rooms.length) {
                        rooms[roomToVacate - 1].vacateRoom();
                    } else {
                        System.out.println("Invalid room number.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting From RoomPannel..!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
          
 }


