package view.login;
import model.ImageReference;
import model.Login;
import model.ToolImage;
import model.database.DBException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;
import model.ToolImageIcon;
import view.FrameHome;

/**
 *
 * @author mju
 */
public class FrameLogin extends JFrame {
    
    String userName;
    String password;
    String loginMsg;
    ToolImage toolImage;
    ImageIcon imageIcon;
    
    public FrameLogin() {  
        
        initComponents();

        //load image
        try {
            toolImage = new ToolImage();
            for (ImageReference imageRef : toolImage.getListImageReference()) {
                if (imageRef.getImageName().equals("background-test-1280x720.jpg")) {
                    imageIcon = new ImageIcon(ImageIO.read(new URL(imageRef.getStrUrl())));
                    jLabelBackground.setIcon(imageIcon);
                }
            }
        }
        catch (Exception ex)
        {

        }
        
        setLocationRelativeTo(null);        
        setVisible(true);
        
        jButtonSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userName=jTextFieldUserName.getText();
                password= String.valueOf(jPasswordField.getPassword());
                try {
                    loginMsg=Login.loginCheck(userName, password);
                } catch (DBException dbException) {
                    dbException.printStackTrace();
                }
                if(loginMsg.equals("pass")){
                    FrameHome frameHome=new FrameHome(userName);
                    dispose();
                }
                else{
                    JOptionPane.showMessageDialog(jButtonSubmit, loginMsg, "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        jButtonSignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameSignUp frameSignUp=new FrameSignUp();
                dispose(); 
            }
        });
    }   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldUserName = new javax.swing.JTextField();
        jLabelUserName = new javax.swing.JLabel();
        jPasswordField = new javax.swing.JPasswordField();
        jLabelPassword = new javax.swing.JLabel();
        jButtonSubmit = new javax.swing.JButton();
        jButtonSignUp = new javax.swing.JButton();
        jLabelBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(640, 480));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldUserName.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        getContentPane().add(jTextFieldUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(527, 164, 158, 42));

        jLabelUserName.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelUserName.setText("username");
        getContentPane().add(jLabelUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(409, 164, 82, 42));
        getContentPane().add(jPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(527, 251, 158, 37));

        jLabelPassword.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelPassword.setText("password");
        getContentPane().add(jLabelPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(409, 247, 82, 42));

        jButtonSubmit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonSubmit.setText("submit");
        jButtonSubmit.setToolTipText("");
        getContentPane().add(jButtonSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(409, 355, 121, 42));

        jButtonSignUp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonSignUp.setText("sign up");
        getContentPane().add(jButtonSignUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(644, 355, 111, 42));

        jLabelBackground.setText("background-test.jpg");
        getContentPane().add(jLabelBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSignUp;
    private javax.swing.JButton jButtonSubmit;
    private javax.swing.JLabel jLabelBackground;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelUserName;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JTextField jTextFieldUserName;
    // End of variables declaration//GEN-END:variables
}
