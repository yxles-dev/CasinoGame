import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {

    public static Connection getConnection() throws SQLException{
        Connection con = DriverManager.getConnection("jdbc:mariadb://localhost/digibet", "root", "DJs231205");
        return con;
    }  
}
