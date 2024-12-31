import java.util.Scanner;

public class StaffPannel {

    public void stafpannel(){
        System.out.println("|****Welcome Staffs****|");
        while (true) {
            Scanner s=new Scanner(System.in);
            System.out.println("1.Staff Entry");
            System.out.println("2.Staff Exit");
            System.out.println("3.Exit");
            System.out.println("Enter Your Option:");
            int option=s.nextInt();
            switch (option) {
                case 1:
                   StaffEntry entry=new StaffEntry();
                   entry.stafentry();
                    break;
                case 2:
                StaffExit staf=new StaffExit();
                staf.stafExit();
                   
                    break;
                case 3:
                  System.out.println("Exiting from Enrty Page.."); 
                   return;

                default:
                System.out.println("Error Occuring inn your code..");
                    break;
            }
        }
    }
}
