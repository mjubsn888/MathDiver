package model.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Practice {

    public static void insertPracticeForNewUser(String user_name) throws DBException {

        String sql="insert into practice (user_id,user_name,test_id,subject,level)(select user_id,user_name,test_id,subject,level from test where user_name=?)";;
        Connection conn=DBConnection.getConn();

        //String efg="efg";
        try(PreparedStatement preparedStatement=conn.prepareStatement(sql))
        {
            preparedStatement.setString(1, user_name);
            preparedStatement.executeUpdate();
        }
        catch (SQLException ex) {
            throw new DBException(ex);
        }
    }


}
