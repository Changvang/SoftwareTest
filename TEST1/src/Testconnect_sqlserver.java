import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;
/**
 *
 * @author giasutinhoc.vn
 */
public class Testconnect_sqlserver {
    public static void main(String[] args) {

        try {
            List<Integer> Ramdom_List = new ArrayList<Integer>();
            Ramdom_List.add(1);
            Ramdom_List.add(2);
            Ramdom_List.add(5);
            System.out.println(ExecuteFunction.CreateRandomteams(32));

        } catch (Exception e) {
            e.printStackTrace();
        }

//        try {
//            String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=TestDBS";
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            Connection conn = DriverManager.getConnection(dbURL,"sa", "123");
//            if (conn != null) {
//                System.out.println("Connected");
//                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
//                System.out.println("Driver name: " + dm.getDriverName());
//                System.out.println("Driver version: " + dm.getDriverVersion());
//                System.out.println("Product name: " + dm.getDatabaseProductName());
//                System.out.println("Product version: " + dm.getDatabaseProductVersion());
//
//                try (Connection con = conn; Statement stmt = con.createStatement();) {
//                    String SQL = "SELECT * FROM Student";
//                    ResultSet rs = stmt.executeQuery(SQL);
//
//                    // Iterate through the data in the result set and display it.
//                    while (rs.next()) {
//                        System.out.println(rs.getString("MSSV") + " : " + rs.getString("FirstName") + " " + rs.getString("LastName"));
//                    }
//                }
//                // Handle any errors that may have occurred.
//                catch (SQLException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        } catch (SQLException | ClassNotFoundException ex) {
//            System.err.println("Cannot connect database, " + ex);
//        }

    }
}