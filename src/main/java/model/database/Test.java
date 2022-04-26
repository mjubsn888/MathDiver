package model.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

    public static void insertTestForNewUser(String user_name) throws DBException {

        String sql = "insert into test (user_id,user_name,subject,level,test_id)(select distinct a.user_id,a.user_name,b.subject,b.level, b.test_id from user as a cross join subject as b where a.user_name=?)";
        ;
        Connection conn = DBConnection.getConn();

        //String efg="efg";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, user_name);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new DBException(ex);
        }
    }
}

