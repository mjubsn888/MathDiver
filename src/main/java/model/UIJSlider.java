/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.swing.JSlider;

/**
 *
 * @author mju
 */
public class UIJSlider {
    
    private final int min=0;
    private final int max=2;
    
    
public UIJSlider(){    
    
    
}
    
public void setSliderForScreenSize(JSlider jSlider)
{
    jSlider.setMaximum(max);
    jSlider.setMinimum(min);    
}
}





