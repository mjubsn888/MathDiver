package model;

import model.database.DBConnection;
import model.database.DBException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DashboardItem {
    String user_name;
    String level;
    String subject;
    String test_id;
    String activity;

    int correct=0;
    int total=0;

    public DashboardItem(String user_name, String activity, String test_id) throws DBException {
        this.user_name=user_name;
        this.test_id=test_id;
        if(activity.equals("practice")){
           getScorePracticeByUserName(user_name, test_id);            
        }
        else{
           getScoreTestByUserName(user_name, test_id);
        }
    }

    public void getScorePracticeByUserName(String user_name, String test_id) throws DBException {

        String sql="select user_name, level, subject, test_id, correct, total from practice where user_name=? and test_id=?";
        Connection conn= DBConnection.getConn();

        try(PreparedStatement preparedStatement=conn.prepareStatement(sql))
        {
            preparedStatement.setString(1, user_name);
            preparedStatement.setString(2, test_id);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                this.user_name=resultSet.getString("user_name");
                this.test_id=resultSet.getString("test_id");
                this.subject=resultSet.getString("subject");
                this.correct=resultSet.getInt("correct");
                this.total=resultSet.getInt("total");
            }
            else
            {
                resultSet.close();
            }
        }
        catch (SQLException ex) {
            throw new DBException(ex);
        }
    }

    public void getScoreTestByUserName(String user_name, String test_id) throws DBException {

        String sql="select user_name, level, subject, test_id, correct, total from test where user_name=? and test_id=?";
        Connection conn= DBConnection.getConn();

        try(PreparedStatement preparedStatement=conn.prepareStatement(sql))
        {
            preparedStatement.setString(1, user_name);
            preparedStatement.setString(2, test_id);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                this.user_name=resultSet.getString("user_name");
                this.test_id=resultSet.getString("test_id");
                this.subject=resultSet.getString("subject");
                this.correct=resultSet.getInt("correct");
                this.total=resultSet.getInt("total");
            }
            else
            {
                resultSet.close();
            }
        }
        catch (SQLException ex) {
            throw new DBException(ex);
        }
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setUsername(String username) {
        this.user_name = user_name;
    }

    public int getCorrect() {
        return correct;
    }

    public int getTotal() {
        return total;
    }

    public String getSubject() {
        return subject;
    }
}
