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
public class FrameSignUp extends JFrame {
    
    String userName;
    String password;
    String passwordCheck;

    String loginMsg;
    ToolImage toolImage;
    ImageIcon imageIcon;
    
    public FrameSignUp() {  
        
        initComponents();        
        setLocationRelativeTo(null);        
        setVisible(true);

        //load image
        try {
            toolImage = new ToolImage();
            for (ImageReference imageRef : toolImage.getListImageReference()) {
                if (imageRef.getImageName().equals("background-test-1280x720.jpg")) {
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
        
        jButtonSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userName = jTextFieldUserName.getText();
                password = String.valueOf(jPasswordField.getPassword());
                passwordCheck = String.valueOf(jPasswordFieldChk.getPassword());

                try {
                    loginMsg = Login.signUpCheck(userName, password, passwordCheck);
                    if (loginMsg.equals("pass")) {
                        Login.signUp(userName, password);
                        FrameHome frameHome = new FrameHome(userName);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, loginMsg, "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                } catch (DBException dbException) {
                    dbException.printStackTrace();
                }
            }
        });

        jButtonReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextFieldUserName.setText("");
                jPasswordField.setText("");
            }
        });
        
        //3. add listener to buttons
        jButtonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameLogin frameLogin=new FrameLogin();
                dispose();
            }
        });
    }   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonSubmit = new javax.swing.JButton();
        jButtonReset = new javax.swing.JButton();
        jTextFieldUserName = new javax.swing.JTextField();
        jPasswordField = new javax.swing.JPasswordField();
        jLabelUserName = new javax.swing.JLabel();
        jLabelPassword = new javax.swing.JLabel();
        jLabelPassword1 = new javax.swing.JLabel();
        jPasswordFieldChk = new javax.swing.JPasswordField();
        jButtonBack = new javax.swing.JButton();
        jLabelBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(640, 480));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonSubmit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonSubmit.setText("submit");
        jButtonSubmit.setToolTipText("");
        getContentPane().add(jButtonSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 420, 84, 42));

        jButtonReset.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonReset.setText("reset");
        getContentPane().add(jButtonReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 420, 80, 42));

        jTextFieldUserName.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        getContentPane().add(jTextFieldUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 160, 232, 42));
        getContentPane().add(jPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 250, 232, 37));

        jLabelUserName.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelUserName.setText("username");
        getContentPane().add(jLabelUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, 82, 42));

        jLabelPassword.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelPassword.setText("password");
        getContentPane().add(jLabelPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 240, 82, 42));

        jLabelPassword1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelPassword1.setText("retype password");
        getContentPane().add(jLabelPassword1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 330, 100, 42));
        getContentPane().add(jPasswordFieldChk, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 330, 232, 37));

        jButtonBack.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonBack.setMaximumSize(new java.awt.Dimension(120, 80));
        getContentPane().add(jButtonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 70, 80, 120));

        jLabelBackground.setText("background-test.jpg");
        getContentPane().add(jLabelBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonReset;
    private javax.swing.JButton jButtonSubmit;
    private javax.swing.JLabel jLabelBackground;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelPassword1;
    private javax.swing.JLabel jLabelUserName;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JPasswordField jPasswordFieldChk;
    private javax.swing.JTextField jTextFieldUserName;
    // End of variables declaration//GEN-END:variables
}
