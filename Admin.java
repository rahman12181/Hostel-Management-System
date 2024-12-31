import java.util.Scanner;

public class Admin {

    public void admin(){
        System.out.println("Only Admin Can Access AdminPannel:");
        String adminPassword="rahman__12181";
        System.out.println("Enter Admin password");
        Scanner s=new Scanner(System.in);
        String entredPassword=s.nextLine();       
        
            if (entredPassword.equals(adminPassword)) {
                System.out.println("|***Welcome Admin***|");
               // System.out.println("your code exicute Successfully");
            }
            else if(!entredPassword.equals(adminPassword)){
                System.out.println("Incorrect Password"+"\nTry Again");
                return;
            }
            else{
                System.out.println("Code Not Exicuted Successfully");
            }

            while (true) {
                
                System.out.println("1.RoomManagement");
                System.out.println("2.FeeManagement");
                System.out.println("3.StudentManagement");
                System.out.println("4.StaffManagement");
                System.out.println("5.ComplaintManagement");
                System.out.println("6.AttendenceManagement");
                System.out.println("7.MessManagement");
                System.out.println("8.Exit");
                System.out.println("Enter Your Requrement..");
                int option=s.nextInt();

                switch (option) {
                    case 1:
                        RoomManagement roomManagement=new RoomManagement();
                        roomManagement.roomManagement();
                        break;
                    case 2:
                        FeeManagement fees=new FeeManagement();
                        fees.FeeManagement();
                        break;
                    case 3:
                        StudentManagement studentManagement=new StudentManagement();
                        studentManagement.StudentManagement();
                        break;
                    case 4:
                         AdminStaffPannel staffPannel=new AdminStaffPannel();
                         staffPannel.staffPannel();
                        break;
                    case 5:
                        //code is under process  you can add your own code here
                        break;
                    case 6:
                        //code is under process you can add your own code here
                        break;    
                
                    case 7:
                        //code is under process you can add your own code here
                        break;
                    case 8:
                        System.out.println("Exited Successfully");
                        return;
                      
                    default:
                    System.out.println("Your code have some problem");
                        break;
                }
            }
    }
}
