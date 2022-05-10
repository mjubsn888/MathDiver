/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author mju
 */
public class ToolImageIcon {
    
    ArrayList<ImageIcon> listImageIcon;     
    private ImageIcon imageIcon;
    private Image image;    
    private String imageName;
    private URL url;
    
    public ToolImageIcon(){    
        
        listImageIcon=new ArrayList<>(); 

        try {            
            imageIcon=new ImageIcon(ImageIO.read(new URL("https://images2.imgbox.com/2b/b6/F2xYwcRP_o.jpg")),"background-test-1280x720.jpg");  
            listImageIcon.add(imageIcon);
            imageIcon=new ImageIcon(ImageIO.read(new URL("https://images2.imgbox.com/c2/18/x0rU3BH1_o.png")),"back-120x80.jpg");
            listImageIcon.add(imageIcon);     
            imageIcon=new ImageIcon(ImageIO.read(new URL("https://images2.imgbox.com/57/3f/FF5uhuk0_o.jpg")),"homepage-1280x720.jpg");
            listImageIcon.add(imageIcon);  
            imageIcon=new ImageIcon(ImageIO.read(new URL("https://images2.imgbox.com/b7/e2/4uDJ6cAi_o.png")),"porthole-k1-180x160.png");
            listImageIcon.add(imageIcon);  
            imageIcon=new ImageIcon(ImageIO.read(new URL("https://images2.imgbox.com/27/7e/hNkjOxu6_o.png")),"porthole-23-180x160.png");            
            listImageIcon.add(imageIcon);  
            imageIcon=new ImageIcon(ImageIO.read(new URL("https://images2.imgbox.com/21/e3/VgBhwZxT_o.png")),"porthole-4-180x160.png");          
            listImageIcon.add(imageIcon); 
            imageIcon=new ImageIcon(ImageIO.read(new URL("https://images2.imgbox.com/f3/f5/84zI2fbr_o.jpg")),"standard-k1-1280x720.jpg");
            listImageIcon.add(imageIcon);
            imageIcon=new ImageIcon(ImageIO.read(new URL("https://images2.imgbox.com/2a/38/wI9ktsA8_o.jpg")),"standard-23-1280x720.jpg");          
            listImageIcon.add(imageIcon);           
            imageIcon=new ImageIcon(ImageIO.read(new URL("https://images2.imgbox.com/33/bc/opvy8SBx_o.jpg")),"standard-4-1280x720.jpg");          
            listImageIcon.add(imageIcon);    

            
            
            
        } catch (Exception e) {
        }  
    }

    public ArrayList<ImageIcon> getListImageIcon() {
        return listImageIcon;
    }
    
    
}