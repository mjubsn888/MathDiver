package model;

public class Login {

    public static boolean loginCheck(String username, char[] password){
       boolean b=false;

        if(username.equals(String.valueOf(password))){
            b=true;
        }
        return b;
    }

}
