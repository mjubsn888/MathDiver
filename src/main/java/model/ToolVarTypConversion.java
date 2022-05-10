package model;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ToolVarTypConversion {

    public static String mapIntegerToString(int i) {
        String s = "";

        if (i == 1) {
            s = "A";
        } else if (i == 2) {
            s = "B";
        } else if (i == 3) {
            s = "C";
        } else if (i == 4) {
            s = "D";
        } else {
            s = "";
        }
        return s;
    }
    
    
    public static URL mapStringToUrl(String s){        
        URL url=null;        
            try {
                url=new URL(s);                
            } catch (IOException e) {
            }        
        return url;
    }



}    



         
         



