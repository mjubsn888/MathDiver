package model.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

    public static void insertTestForNewUser(String user_name) throws DBException {

        String sql = "insert into test (user_id,user_name,subject,level,test_id)(select distinct a.user_id,a.user_name,b.subject,b.level, b.test_id from user as a cross join standard as b where a.user_name=?)";
        Connection conn = DBConnection.getConn();

        //String efg="efg";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, user_name);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new DBException(ex);
        }
    }

    public static void updateTest(String user_name, String test_id, int nbrOfCorrect, int nbrOfTotal) throws DBException {

        String sql="update test set correct=correct+?, total=total+? where user_name=? and test_id=?";
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

    public static void resetTest(String user_name, String test_id) throws DBException {

        String sql="update test set correct=0, total=0 where user_name=? and test_id=?";
        Connection conn=DBConnection.getConn();

        //String efg="efg";
        try(PreparedStatement preparedStatement=conn.prepareStatement(sql))
        {
            preparedStatement.setString(1, user_name);
            preparedStatement.setString(2, test_id);
            preparedStatement.executeUpdate();
        }
        catch (SQLException ex) {
            throw new DBException(ex);
        }
    }
}

