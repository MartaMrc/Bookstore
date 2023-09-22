package jdbc.project.DbConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnection {

    //create connection with DB
    static Connection connection;

    public static Connection createDbConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/Bookstore1";
            String username = "root";
            String password = "sqlserver";
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return connection;
    }
}
