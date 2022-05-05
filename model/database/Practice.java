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

    public static void updatePractice(String user_name, String test_id, int nbrOfCorrect, int nbrOfTotal) throws DBException {

        String sql="update practice set correct=correct+?, total=total+? where user_name=? and test_id=?";
        Connection conn=DBConnection.getConn();

        //String efg="efg";
        try(PreparedStatement preparedStatement=conn.prepareStatement(sql))
        {
            preparedStatement.setInt(1, nbrOfCorrect);
            preparedStatement.setInt(2, nbrOfTotal);
            preparedStatement.setString(3, user_name);
            preparedStatement.setString(4, test_id);
            preparedStatement.executeUpdate();
        }
        catch (SQLException ex) {
            throw new DBException(ex);
        }
    }
}