package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private final int port = 3306;
    private final String db_Name = "DentopsDB";
    private final String user = "root";
    private final String password = "root1234";
    private Connection connection;

    public DataBaseConnection(){
        String url = "jdbc:mysql://localhost:"+port+"/"+db_Name;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println((e.getMessage()));
        }
    }

    public Connection getConnection() {
        return connection;
    }
}

