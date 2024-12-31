import java.util.Scanner;

public class StudentManagement {

    public void StudentManagement(){
           System.out.println("<---Admin Student Management--->");
           while (true) {
            Scanner s=new Scanner(System.in);
             System.out.println("1.StudentRequest");
             System.out.println("2.Exit");
             System.out.println("Enter Your Option");
             int option=s.nextInt();
             switch (option) {
                case 1:
                  StudentRequest request=new StudentRequest();
                  request.studentREquest();
                    break;
                case 2:
                    System.out.println("Exiting From StudentManagement Pannel..");
                    return; 

                default:
                System.out.println("Error Occuring");
                    break;
             }

           }
    }
}
