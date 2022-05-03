package model;

import model.database.*;

public class Login {

    private static String loginMsg;

    public static String loginCheck(String username, String password) throws DBException {
        loginMsg = "pass";

        loginMsg = checkIfUsernamePasswordEmpty(username, password);
        if(!loginMsg.equals("pass")){
            return loginMsg;
        }

        if (!User.checkIfUserExist(username)) {
            loginMsg = "user does not exist";
            return loginMsg;
        }

        loginMsg = checkIfUsernameMatchPassword(username, password);
        return loginMsg;
    }

    public static String signUpCheck(String username, String password) throws DBException {
        loginMsg = "pass";
        if (User.checkIfUserExist(username)) {
            loginMsg = "user already exist";
            return loginMsg;
        }
        loginMsg = checkIfUsernamePasswordEmpty(username, password);
        if(!loginMsg.equals("pass")){
            return loginMsg;
        }
        loginMsg = checkIfUsernameMatchPassword(username, password);

        return loginMsg;
    }

    public static void signUp(String username, String password) throws DBException {
        User.insertNewUser(username, password);
        User.updateUserId();
        Test.insertTestForNewUser(username);
        Practice.insertPracticeForNewUser(username);
        Reward.insertRewardForNewUser(username);
    }

    public static String checkIfUsernameMatchPassword(String username, String password) {
        loginMsg = "pass";
        if (!username.equals(password)) {
            loginMsg = "user name must match password";
        }
        return loginMsg;
    }

    public static String checkIfUsernamePasswordEmpty(String username, String password) throws DBException {
        loginMsg = "pass";
        if(username.equals("") || password.equals(""))
        {
            loginMsg="user name or password is empty";
        }
        return loginMsg;
    }
}

