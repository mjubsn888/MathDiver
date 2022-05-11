package model;

import model.database.DBConnection;
import model.database.DBException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ToolReward {
    String user_name;
    String level;

    int reward_1=0;
    int reward_2=0;
    int reward_3=0;
    int reward_4=0;

    public ToolReward(String user_name, String level){
        this.user_name=user_name;
        this.level=level;
    }

    public void getRewardByUserName(String user_name, String level) throws DBException {

        String sql="select username, level, reward_1, reward_2, reward_3, reward_4 from reward where user_name=? and level=?";
        Connection conn= DBConnection.getConn();

        try(PreparedStatement preparedStatement=conn.prepareStatement(sql))
        {
            preparedStatement.setString(1, user_name);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                this.user_name=resultSet.getString("user_name");
                this.level=resultSet.getString("level");
                this.reward_1=resultSet.getInt("reward_1");
                this.reward_2=resultSet.getInt("reward_2");
                this.reward_3=resultSet.getInt("reward_3");
                this.reward_4=resultSet.getInt("reward_4");
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

    public int getReward_1() {
        return reward_1;
    }

    public int getReward_2() {
        return reward_2;
    }

    public int getReward_3() {
        return reward_3;
    }

    public int getReward_4() {
        return reward_4;
    }
}
