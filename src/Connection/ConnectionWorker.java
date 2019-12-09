package Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionWorker {
    public static Connection getConnection(){
        Connection connection = null;
        try
        {
            String dbURL = "jdbc:mysql://localhost:3306/pts";
            String dbUser ="root";
            String dbPassword="";
            connection = DriverManager.getConnection(dbURL,dbUser,dbPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }

return connection;
    }
}
