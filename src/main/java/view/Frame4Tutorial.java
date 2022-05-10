
package view;

import java.awt.Dimension;
import model.ImageReference;
import model.ToolImage;
import model.ToolImageIcon;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.security.auth.Subject;
import model.ToolColor;

/**
 *
 * @author mju
 */
public class Frame4Tutorial extends JFrame {    
    
    String userName;
    String level;
    String subject;
    ToolImage toolImage;
    ImageIcon imageIcon;
    ToolColor toolColor;
    
    public Frame4Tutorial(String userName, String level, String subject) { 
        
        this.userName=userName; 
        this.level=level;
        this.subject=subject;
          
        initComponents();
        setLocationRelativeTo(null);        
        setVisible(true);
        
        toolColor=new ToolColor();
        jButtonTutorial1.setBackground(toolColor.getColor("orange"));
        jButtonTutorial2.setBackground(toolColor.getColor("orange"));
        jButtonTutorial3.setBackground(toolColor.getColor("orange"));
        
        jButtonTutorial1.setText("fraction");
        jButtonTutorial2.setText("decimal");
        jButtonTutorial3.setText("shape");
        
        this.setPreferredSize(new Dimension(1280, 720));

        //load image
        try {
            toolImage = new ToolImage();
            for (ImageReference imageRef : toolImage.getListImageReference()) {
                if (imageRef.getImageName().equals("background-tutorial-4-1280x720.png")) {
                    imageIcon = new ImageIcon(ImageIO.read(new URL(imageRef.getStrUrl())));
                    jLabelBackground.setIcon(imageIcon);
                }
                if(imageRef.getImageName().equals("back-120x80.jpg"))
                {
                    imageIcon = new ImageIcon(ImageIO.read(new URL(imageRef.getStrUrl())));
                    jButtonBack.setIcon(imageIcon);
                }            }
        }
        catch (Exception ex)
        {

        }

        jButtonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameActivityMenu frameActivityMenu=new FrameActivityMenu(userName, level, subject);
                dispose();
            }
        });
        
        jLabelUserName.setText(userName);  
        
        
        jButtonTutorial1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            try {
            String urlMult = "https://www.youtube.com/watch?v=p33BYf1NDAE";
            
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(urlMult));
            
            } catch (Exception e2) {
            e2.printStackTrace();
            }
            
            }
        }); 
        
        
        jButtonTutorial2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            try {
            String urlMult = "https://www.youtube.com/watch?v=BItpeFXC4vA";        
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(urlMult));
            
            } catch (Exception e2) {
            e2.printStackTrace();
            }
            
            }
        });
        
        jButtonTutorial3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            try {
            String urlMult = "https://www.youtube.com/watch?v=J-kLTQPNnP";        
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(urlMult));
            
            } catch (Exception e2) {
            e2.printStackTrace();
            }
            
            }
        });
    }   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonTutorial3 = new javax.swing.JButton();
        jLabelUserName = new javax.swing.JLabel();
        jButtonBack = new javax.swing.JButton();
        jButtonTutorial1 = new javax.swing.JButton();
        jButtonTutorial2 = new javax.swing.JButton();
        jLabelBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(640, 480));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        setSize(getPreferredSize());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonTutorial3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonTutorial3.setMaximumSize(new java.awt.Dimension(180, 160));
        jButtonTutorial3.setPreferredSize(new java.awt.Dimension(180, 160));
        getContentPane().add(jButtonTutorial3, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 270, 180, 150));

        jLabelUserName.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelUserName.setText("username");
        getContentPane().add(jLabelUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 64, 41));

        jButtonBack.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonBack.setMaximumSize(new java.awt.Dimension(120, 80));
        getContentPane().add(jButtonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 20, 80, 120));

        jButtonTutorial1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonTutorial1.setMaximumSize(new java.awt.Dimension(180, 160));
        jButtonTutorial1.setPreferredSize(new java.awt.Dimension(180, 160));
        getContentPane().add(jButtonTutorial1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 180, 150));

        jButtonTutorial2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonTutorial2.setMaximumSize(new java.awt.Dimension(180, 160));
        jButtonTutorial2.setPreferredSize(new java.awt.Dimension(180, 160));
        getContentPane().add(jButtonTutorial2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 270, 180, 150));

        jLabelBackground.setText("background-test.jpg");
        getContentPane().add(jLabelBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonTutorial1;
    private javax.swing.JButton jButtonTutorial2;
    private javax.swing.JButton jButtonTutorial3;
    private javax.swing.JLabel jLabelBackground;
    private javax.swing.JLabel jLabelUserName;
    // End of variables declaration//GEN-END:variables
}
