package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import model.ImageReference;
import model.ToolColor;
import model.ToolImage;
import model.ToolImageIcon;
import model.database.DBException;
import view.login.FrameLogin;

/**
 *
 * @author mju
 */
public class FrameHome extends JFrame {
    
    String userName;
    ToolImageIcon toolImageIcon;
    ToolImage toolImage;
    ImageIcon imageIcon;
    ToolColor toolColor;
    
    public FrameHome(String userName) {  
        
        this.userName=userName;
        initComponents();
        setLocationRelativeTo(null);        
        setVisible(true);

        //load image
        try {
            toolImage = new ToolImage();
            for (ImageReference imageRef : toolImage.getListImageReference()) {
                
                //one if statement for one image
                if (imageRef.getImageName().equals("homepage-1280x720.jpg")) {
                    imageIcon = new ImageIcon(ImageIO.read(new URL(imageRef.getStrUrl())));
                    jLabelBackground.setIcon(imageIcon);
                }
                
                
                if(imageRef.getImageName().equals("back-120x80.jpg"))
                {
                    imageIcon = new ImageIcon(ImageIO.read(new URL(imageRef.getStrUrl())));
                    jButtonBack.setIcon(imageIcon);
                }
                if(imageRef.getImageName().equals("porthole-k1-180x160.png"))
                {
                    imageIcon = new ImageIcon(ImageIO.read(new URL(imageRef.getStrUrl())));
                    jButtonK1.setIcon(imageIcon);
                    jButtonK1.setOpaque(false);
                    jButtonK1.setBorderPainted(false);
                }
                if(imageRef.getImageName().equals("porthole-23-180x160.png"))
                {
                    imageIcon = new ImageIcon(ImageIO.read(new URL(imageRef.getStrUrl())));
                    jButton23.setIcon(imageIcon);
                    jButton23.setOpaque(false);
                    jButton23.setBorderPainted(false);
                }
                
                
                if(imageRef.getImageName().equals("porthole-4-180x160.png"))
                {
                    imageIcon = new ImageIcon(ImageIO.read(new URL(imageRef.getStrUrl())));
                    jButton4.setIcon(imageIcon);
                    jButton4.setOpaque(false);
                    jButton4.setBorderPainted(false);
                }
                
                if (imageRef.getImageName().equals("orange")) {
                    imageIcon = new ImageIcon(ImageIO.read(new URL(imageRef.getStrUrl())));
                    jButtonDashboard.setIcon(imageIcon);
                }
                
                
                
            }
        }
        catch (Exception ex)
        {

        }
        
        toolColor=new ToolColor();
        jButtonRewards.setBackground(toolColor.getColor("orange"));
        jButtonDashboard.setBackground(toolColor.getColor("orange"));

        /*       toolImageIcon=new ToolImageIcon();
        for (ImageIcon imageIcon : toolImageIcon.getListImageIcon()) {
            if(imageIcon.getDescription().equals("homepage-1280x720.jpg"))
            {
                jLabelBackground.setIcon(imageIcon);
            }
            if(imageIcon.getDescription().equals("back-120x80.jpg"))
            {
                jButtonBack.setIcon(imageIcon);
            }  
            if(imageIcon.getDescription().equals("porthole-k1-180x160.png"))
            {
                jButtonK1.setIcon(imageIcon);
                jButtonK1.setOpaque(false);
                jButtonK1.setBorderPainted(false);
            }   
            if(imageIcon.getDescription().equals("porthole-23-180x160.png"))
            {
                jButton23.setIcon(imageIcon);
                jButton23.setOpaque(false);
                jButton23.setBorderPainted(false);
            }   
            if(imageIcon.getDescription().equals("porthole-4-180x160.png"))
            {
                jButton4.setIcon(imageIcon);
                jButton4.setOpaque(false);
                jButton4.setBorderPainted(false);
            }  
        }*/
        
        jLabelUser.setText(userName);
        
        jButtonK1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameK1Subjects frameK1=new FrameK1Subjects(userName);
                dispose(); 
            }
        });
        
        jButton23.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Frame23Subjects frame23=new Frame23Subjects(userName);
                dispose(); 
            }
        });
        
        jButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Frame4Subjects frame4=new Frame4Subjects(userName);
                dispose(); 
            }
        });
        
        jButtonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameLogin frameLogin=new FrameLogin();
                dispose(); 
            }
        });   
        
        jButtonRewards.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameK1Rewards frameK1Rewards=new FrameK1Rewards(userName);
                dispose();                
            }
        });
        
        jButtonDashboard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FrameDashboard frameDashboard=new FrameDashboard(userName);
                    dispose();
                } catch (DBException ex) {
                    Logger.getLogger(FrameHome.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonK1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabelUser = new javax.swing.JLabel();
        jButtonBack = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButtonRewards = new javax.swing.JButton();
        jButtonDashboard = new javax.swing.JButton();
        jLabelBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(640, 480));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonK1.setBackground(new java.awt.Color(255, 255, 0));
        jButtonK1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonK1.setMaximumSize(new java.awt.Dimension(180, 160));
        jButtonK1.setMinimumSize(new java.awt.Dimension(180, 160));
        jButtonK1.setPreferredSize(new java.awt.Dimension(180, 160));
        jButtonK1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonK1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonK1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 270, -1, -1));

        jButton4.setBackground(new java.awt.Color(255, 255, 0));
        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton4.setMaximumSize(new java.awt.Dimension(180, 160));
        jButton4.setMinimumSize(new java.awt.Dimension(180, 160));
        jButton4.setPreferredSize(new java.awt.Dimension(180, 160));
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 270, -1, -1));

        jLabelUser.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelUser.setText("user");
        getContentPane().add(jLabelUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 94, 91, 45));

        jButtonBack.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonBack.setMaximumSize(new java.awt.Dimension(120, 80));
        getContentPane().add(jButtonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 40, 80, 120));

        jButton23.setBackground(new java.awt.Color(255, 255, 0));
        jButton23.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton23.setMaximumSize(new java.awt.Dimension(180, 160));
        jButton23.setMinimumSize(new java.awt.Dimension(180, 160));
        jButton23.setPreferredSize(new java.awt.Dimension(180, 160));
        getContentPane().add(jButton23, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 270, -1, -1));

        jButtonRewards.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonRewards.setText("rewards");
        getContentPane().add(jButtonRewards, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 580, 90, 30));

        jButtonDashboard.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonDashboard.setText("dashboard");
        getContentPane().add(jButtonDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 100, 42));

        jLabelBackground.setText("background.jpg");
        getContentPane().add(jLabelBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonK1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonK1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonK1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonDashboard;
    private javax.swing.JButton jButtonK1;
    private javax.swing.JButton jButtonRewards;
    private javax.swing.JLabel jLabelBackground;
    private javax.swing.JLabel jLabelUser;
    // End of variables declaration//GEN-END:variables
}
