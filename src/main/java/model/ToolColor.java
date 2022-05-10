package model;

import java.awt.Color;
import java.util.ArrayList;

public class ToolColor {

    Color color;

    public ToolColor(){

    }

    public Color getColor(String colorName){

        if(colorName.equals("blue1")){
            color=new Color(0,145,255); //starfleet blue: #0091ff
        }
        else if (colorName.equals("blue2")){
            color=new Color(0,115,204); //science blue: #0073cc
        }
        else if (colorName.equals("blue3")){
            color=new Color(0,86,153); //wizard blue: #0072cc
        }
        else if (colorName.equals("sand1")) {
            color=new Color(255,233,201); //wizard blue: #0072cc
        }
        else if (colorName.equals("orange")){
            color=new Color(255,204,0);
        }
        else{
            color=new Color(0,114,204); //wizard blue: #0072cc
        }
        return color;
    }

}
