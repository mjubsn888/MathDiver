package model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    final private static String user="root";
    final private static String password="root";
    final private static String url="jdbc:mysql://localhost:3306/mathdiver";

    private static Connection conn;
    public DBConnection(){}

    public static synchronized Connection getConn() throws DBException {
        if(conn != null){
            return conn;
        }
        else{
            try{
                conn = DriverManager.getConnection(url, user, password);
                return conn;
            }
            catch (SQLException ex){
                throw new DBException(ex);
            }
        }
    }

    public static void main(String[] args) {

    }
}