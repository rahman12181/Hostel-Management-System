import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class  FeeManagement{

    public void FeeManagement(){
        System.out.println("|******Student Fee Detail******|");
        String url = "jdbc:mysql://localhost:3306/hostelmanagementsystem";
        String username = "root";
        String password = "rahman__12181";
        try {
            Thread.sleep(3000);
        try (Connection connection=DriverManager.getConnection(url, username, password)) {
            
                 String query="SELECT \r\n" + //
                                          "    sf.Fee_ID, \r\n" + //
                                          "    sf.Fee_Amount, \r\n" + //
                                          "    sf.Date, \r\n" + //
                                          "    sf.studentID, \r\n" + //
                                          "    sr.studentName, \r\n" + //
                                          "    sr.studentEmail, \r\n" + //
                                          "    sr.allotedRoom\r\n" + //
                                          "FROM \r\n" + //
                                          "    studentfees sf\r\n" + //
                                          "LEFT JOIN \r\n" + //
                                          "    studentrooms sr\r\n" + //
                                          "ON \r\n" + //
                                          "    sf.studentID = sr.studentID\r\n" + //
                                          "\r\n" + //
                                          "UNION\r\n" + //
                                          "\r\n" + //
                                          "SELECT \r\n" + //
                                          "    sf.Fee_ID, \r\n" + //
                                          "    sf.Fee_Amount, \r\n" + //
                                          "    sf.Date, \r\n" + //
                                          "    sr.studentID, \r\n" + //
                                          "    sr.studentName, \r\n" + //
                                          "    sr.studentEmail, \r\n" + //
                                          "    sr.allotedRoom\r\n" + //
                                          "FROM \r\n" + //
                                          "    studentfees sf\r\n" + //
                                          "RIGHT JOIN \r\n" + //
                                          "    studentrooms sr\r\n" + //
                                          "ON \r\n" + //
                                          "    sf.studentID = sr.studentID;\r\n" + //
                                          " ";

                                    try (PreparedStatement statement = connection.prepareStatement(query)) {
                                    ResultSet resultSet = statement.executeQuery();

                
                                    while (resultSet.next()) {
                                      System.out.println("<-------********************-------->");
                                      System.out.println("Fee ID: " + resultSet.getInt("Fee_ID"));
                                      System.out.println("Fee Amount: " + resultSet.getInt("Fee_Amount"));
                                      System.out.println("Date: " + resultSet.getString("Date"));
                                      System.out.println("Student ID: " + resultSet.getInt("studentID"));
                                      System.out.println("Student Name: " + resultSet.getString("studentName"));
                                      System.out.println("Student Email: " + resultSet.getString("studentEmail"));
                                      System.out.println("Alloted Room: " + resultSet.getInt("allotedRoom"));
                                      System.out.println("<-------********************-------->");
                                     
                                     
                }
            }       
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    } catch (Exception e) {
      // TODO: handle exception
    }
    }
}