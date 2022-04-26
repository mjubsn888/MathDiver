package control;

import model.Login;
import model.database.*;
import java.sql.SQLException;

public class TestModel {

    public static void main(String[] args) throws DBException, SQLException {

        String user_name="efg";
        char[] password=user_name.toCharArray();
        Login.signUp(user_name, password);

    }
}