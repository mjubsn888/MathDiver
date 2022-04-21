/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.swing.*;

/**
 *
 * @author mju
 */
public class UIScreen {
    
    public UIScreen(){
        
    }       
    
    public static int [] setScreenDimension(int size){//1=small. 2=medium 3=large
        
        int[] screenDimension=new int[2];
        
        if (size==0) {            
            screenDimension[0]=1280;
            screenDimension[1]=800;            
        } else if(size==1)
        {
            screenDimension[0]=960;
            screenDimension[1]=540;   
        }else if(size==2)
        {
            screenDimension[0]=800;
            screenDimension[1]=400; 
        }      
        
        return screenDimension;
        
    } 

}
