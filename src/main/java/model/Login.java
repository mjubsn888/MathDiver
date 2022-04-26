package model;

import model.database.*;

public class Login {

    public static String loginCheck(String username, char[] password){
       String loginMsg="pass";
       String strPassword=String.valueOf(password);

/*       if(username.equals("") || strPassword.equals(""))
       {
           loginMsg="user name or password is empty";
       }*/

       if(checkLoginCredentials(username, password))
       {
           loginMsg="user name must match password";
       }
       return loginMsg;
    }

    public static boolean checkLoginCredentials(String username, char[] password){
        boolean b=false;
        if(username.equals(String.valueOf(password))){
            b=true;
        }
        return b;
    }

    public static void signUp(String user_name, char[] password) throws DBException {

/*        if(loginCheck(user_name, password)) {


            if (!User.checkIfUserExist(user_name)) {
                User.insertNewUser(user_name, String.valueOf(password));
                User.updateUserId();
                Test.insertTestForNewUser(user_name);
                Practice.insertPracticeForNewUser(user_name);
                Reward.insertRewardForNewUser(user_name);
            } else {
                System.out.println("user already exist");
            }
        }*/
    }
}
