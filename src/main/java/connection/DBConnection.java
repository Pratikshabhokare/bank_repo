package connection;

 
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
 

              private static final String driver = "com.mysql.cj.jdbc.Driver";

              private static final String url = "jdbc:mysql://localhost:3306/bank_db";

              private static final String userName = "root";

              private static final String password = "Tejask21@";

 

              public static Connection getConnection() {

                           Connection conn = null;

 

                           try {

                                         Class.forName(driver);

                                         conn = DriverManager.getConnection(url, userName, password);

                                        // System.out.println("Connection success..");

 

                           } catch (Exception e) {

                                         e.printStackTrace();

 

                           }

                           return conn;

              }

 

}
