package model.database;

import java.sql.*;

public class User {
    private int user_id;
    private String user_name;
    private String password;

    public static User getUserByName(String user_name) throws DBException{

        String sql="select user_name from user where user_name=?";
        Connection conn=DBConnection.getConn();

        try(PreparedStatement preparedStatement=conn.prepareStatement(sql))
        {
            preparedStatement.setString(1, user_name);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                User user=new User();
                user.user_name=resultSet.getString("user_name");
                return user;
            }
            else
            {
                resultSet.close();
                return null;
            }
        }
        catch (SQLException ex) {
            throw new DBException(ex);
        }
    }

    public static boolean checkIfUserExist(String user_name) throws DBException {
        User user=getUserByName(user_name);
        boolean b=false;
        if(user!=null){
            b=true;
        }
        return b;
    }

    public static void insertNewUser(String user_name, String password) throws DBException {

        String sql="insert into user (user_name,password) values (?,?)";;
        Connection conn=DBConnection.getConn();

        try(PreparedStatement preparedStatement=conn.prepareStatement(sql))
        {
            preparedStatement.setString(1, user_name);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();
        }
        catch (SQLException ex) {
            throw new DBException(ex);
        }
    }

    public static void updateUserId() throws DBException {

        String sql="update user as a inner join (select (dense_rank() over (order by user_name)) as user_id,user_name from user) as x "
        +"on a.user_name=x.user_name set a.user_id=x.user_id";

        Connection conn=DBConnection.getConn();

        try
        {
            Statement stmt=conn.createStatement();
            stmt.executeUpdate(sql);
        }
        catch (SQLException ex) {
            throw new DBException(ex);
        }
    }

    public int getUser_id() {
        return user_id;
    }

    public String getUser_name() {
        return user_name;
    }
}
