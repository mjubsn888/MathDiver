
package view;

import model.ImageReference;
import model.ToolImage;
import model.ToolImageIcon;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.security.auth.Subject;

/**
 *
 * @author mju
 */
public class Frame4Subjects extends JFrame {    
    
    String userName;
    String level;
    ToolImage toolImage;
    ImageIcon imageIcon;
    
    public Frame4Subjects(String userName) { 
        
        this.userName=userName; 
        this.level="4";
        initComponents();
        setLocationRelativeTo(null);        
        setVisible(true);

        //load image
        try {
            toolImage = new ToolImage();
            for (ImageReference imageRef : toolImage.getListImageReference()) {
                if (imageRef.getImageName().equals("standard-4-1280x720.jpg")) {
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

        jLabelUserName.setText(userName);   
        
        jButtonFraction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //FrameOption frameOption=new FrameOption(userName, "addition");
                FrameActivityMenu frameActivityMenu=new FrameActivityMenu(userName, level, "Fraction");
            }
        });
        
        jButtonDecimal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameActivityMenu frameActivityMenu=new FrameActivityMenu(userName, level, "Decimal");
            }
        });

        jButtonShape.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameActivityMenu frameActivityMenu=new FrameActivityMenu(userName, level, "Shape");
            }
        });

        jButtonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameHome frameHome=new FrameHome(userName);
                dispose();
            }
        });
    }   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonFraction = new javax.swing.JButton();
        jButtonDecimal = new javax.swing.JButton();
        jButtonShape = new javax.swing.JButton();
        jLabelUserName = new javax.swing.JLabel();
        jButtonBack = new javax.swing.JButton();
        jLabelBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(640, 480));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonFraction.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonFraction.setText("fraction");
        getContentPane().add(jButtonFraction, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, 110, 41));

        jButtonDecimal.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonDecimal.setText("decimal");
        getContentPane().add(jButtonDecimal, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 250, 110, 40));

        jButtonShape.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonShape.setText("shape");
        getContentPane().add(jButtonShape, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 350, 110, 40));

        jLabelUserName.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelUserName.setText("username");
        getContentPane().add(jLabelUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 64, 41));

        jButtonBack.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonBack.setMaximumSize(new java.awt.Dimension(120, 80));
        getContentPane().add(jButtonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 50, 80, 120));

        jLabelBackground.setText("background.jpg");
        getContentPane().add(jLabelBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonDecimal;
    private javax.swing.JButton jButtonFraction;
    private javax.swing.JButton jButtonShape;
    private javax.swing.JLabel jLabelBackground;
    private javax.swing.JLabel jLabelUserName;
    // End of variables declaration//GEN-END:variables
}
