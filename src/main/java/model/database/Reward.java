package model.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Reward {

    public static void insertRewardForNewUser(String user_name) throws DBException {

        String sql="insert into reward (user_id,user_name,level)(select distinct a.user_id,a.user_name,b.level from user as a cross join subject as b where a.user_name=?)";

        Connection conn=DBConnection.getConn();

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
