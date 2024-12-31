import java.util.Scanner;

public class PayHostelFee {

    public void payHostelFee(){
         


        System.out.println("<-----Wlcome to Fees Counter:------>");
        
         while(true){
            Scanner s=new Scanner(System.in);
            System.out.println("1.CheakDews");
            System.out.println("2.SubmitFee");
            System.out.println("3.Exit");
            System.out.println("Enter Your Option:");
            int option=s.nextInt();
            switch (option) {
                case 1:
                    CheakDews fee=new CheakDews();
                    fee.cheakDews();
                    break;
                case 2:
                   SubmitDews submitDews=new SubmitDews();
                   submitDews.SubmitDews();
                break;
                case 3:
                System.out.println("Exiting from CheakDews..");
                return;
                default:
                System.out.println("Error Occuring");
                    break;
            }
         }
    }
}

    

