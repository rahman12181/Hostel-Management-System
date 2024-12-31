import java.util.Scanner;

public class HostelManagementSystem {

    public static void main(String[] args) {
           
       
       //calling login function here
        
        System.out.println("|********|WELCOME TO HOSTEL|**********|\n");
        System.out.println("<---LOGIN---->");
        LoginHostel login=new LoginHostel();
        login.loginHostel();
      
      //your dashboard of hostelmanagementSystem
       System.out.println("|****WELCOME TO HOSTEL DASHBOARD****|");
       Scanner s=new Scanner(System.in);

       while (true) {
         System.out.println(" HOSTEL USER INTERFACE");
         System.out.println("1.Admin");
         System.out.println("2.StudentPannel");
         System.out.println("3.StaffPannel");
         System.out.println("4.Exit");
         
         System.out.println("Enter Your Option");
         int option=s.nextInt();
         switch (option) {
            case 1:
            Admin admin=new Admin();
              admin.admin();
                break;
            case 2:    
            StudentPannel student=new StudentPannel();
            student.StudentPannel();
            break;
            case 3:
            StaffPannel staffs=new StaffPannel();
            staffs.stafpannel();
            break;
            case 4:
            System.out.println("Exited Succesfully"+"\nThnks for Visiting My Hostel");
            return;
            default:
              System.out.println("Error Your Hostel Not Found");
                break;
         }
        
       }
        
      
    }
}