
package view;

import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author mju
 */
public class FrameK1Subjects extends JFrame {    
    
    String userName;
    
    public FrameK1Subjects(String userName) { 
        
        this.userName=userName;  
        initComponents();
        setLocationRelativeTo(null);        
        setVisible(true);
        
        jButtonAddition.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                FrameK1AdditionMenu frame3Parts=new FrameK1AdditionMenu(userName);
                dispose();                
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        
        jButtonSubtraction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                FrameK1SubtractionMenu frameK1SubtractionMenu=new FrameK1SubtractionMenu(userName);
                dispose();                
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });

        jButtonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameHome frameHome=new FrameHome(userName);
                dispose();
            }
        });
        
        jLabelUserName.setText(userName);        
    }   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonAddition = new javax.swing.JButton();
        jButtonSubtraction = new javax.swing.JButton();
        jButtonBack = new javax.swing.JButton();
        jLabelUserName = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(640, 480));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("subtraction");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 410, -1, -1));

        jLabel2.setText("addition");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 190, -1, -1));

        jButtonAddition.setIcon(new javax.swing.ImageIcon("C:\\Users\\Cameron\\Documents\\MathDiver-main\\src\\main\\java\\view\\images\\Counting.JPG")); // NOI18N
        jButtonAddition.setMaximumSize(new java.awt.Dimension(200, 100));
        jButtonAddition.setPreferredSize(new java.awt.Dimension(200, 150));
        getContentPane().add(jButtonAddition, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 490, 180));

        jButtonSubtraction.setIcon(new javax.swing.ImageIcon("C:\\Users\\Cameron\\Documents\\MathDiver-main\\src\\main\\java\\view\\images\\Counting.JPG")); // NOI18N
        jButtonSubtraction.setPreferredSize(new java.awt.Dimension(300, 200));
        getContentPane().add(jButtonSubtraction, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 270, 470, -1));

        jButtonBack.setIcon(new javax.swing.ImageIcon("C:\\Users\\Cameron\\Documents\\MathDiver-main\\src\\main\\java\\view\\images\\Slide1.JPG")); // NOI18N
        jButtonBack.setText("jButton1");
        jButtonBack.setPreferredSize(new java.awt.Dimension(150, 190));
        getContentPane().add(jButtonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 90, -1, -1));

        jLabelUserName.setIcon(new javax.swing.ImageIcon("C:\\Users\\Cameron\\Documents\\MathDiver-main\\src\\main\\java\\view\\images\\K-1PageImage.jpg")); // NOI18N
        jLabelUserName.setAlignmentY(0.0F);
        getContentPane().add(jLabelUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddition;
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonSubtraction;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelUserName;
    // End of variables declaration//GEN-END:variables
}
