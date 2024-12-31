import java.util.Scanner;

public class AdminStaffPannel {

    public void staffPannel(){
        Scanner s=new Scanner(System.in);
        System.out.println("|******Welcome to Staff Pannel******|");
    
        
        while (true) {
            System.out.println("1.Add Staff");
            System.out.println("2.Remove Staff");
            System.out.println("3.See Stafs Info");
            System.out.println("4.See Stafs Daily work");
            System.out.println("Enter your option:");
            int option=s.nextInt();
            switch (option) {
                case 1:
                    AddStaff addstaff=new AddStaff();
                    addstaff.addStaf();
                    break;
                case 2:
                   RemoveStaff remove=new RemoveStaff();
                   remove.removeStaff();
                    break;
                case 3:
                StafsInformation stafinfo=new StafsInformation();
                stafinfo.stafsInformation();  
                case 4:
                 SeeStaffDailyWork dailywork=new SeeStaffDailyWork();
                 dailywork.SeeStaffDailyWork();
                  break;
                case 5:
                System.out.println("Exiting from Your safpannel..");
                   break;
                default:
                System.out.println("Error Occuring");
                    break;
            }
        }
    }
}
