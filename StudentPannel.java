import java.util.Scanner;

public class StudentPannel {

    public void StudentPannel(){
        System.out.println("|******Welcome to StudentPannel******|");

        while(true){
            Scanner s=new Scanner(System.in);
            System.out.println("1.View assigned rooms");
            System.out.println("2.Request Room Change");
            System.out.println("3.Pay Hostel Fee");
            System.out.println("4.Exit");
            System.out.println("Enter your requrement:");
             int option=s.nextInt();

             switch (option) {
                case 1:
                    ViewAssignedRoom  view=new ViewAssignedRoom();
                    view.viewAssignedRoom();
                    break;
                case 2:
                   RequestRoomChange request=new RequestRoomChange();
                   request.requestroomChange();
                    break;
                case 3:
                   PayHostelFee payFee= new PayHostelFee();
                   payFee.payHostelFee();
                     break;
                case 4:
                System.out.println("Exiting from StudentPannel..");
                return; 
                default:
                System.out.println("Error Occcuring in your code");
                    break;
             }
        }
    }
}
