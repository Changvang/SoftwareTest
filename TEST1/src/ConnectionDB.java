import java.sql.*;
/**
 *
 * @author lequa
 */
public class ConnectionDB {
    Connection cnn = null;
    public Connection getConnectionDB(){
        try{
            String uRL="jdbc:sqlserver://localhost:1433;databaseName=WorldCup2019";
            String user = "sa";
            String pass = "123";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cnn = DriverManager.getConnection(uRL, user, pass);
            System.out.println("success");
        }catch(Exception e){
            System.out.println("Fail");
        }
        return cnn;
    }
}