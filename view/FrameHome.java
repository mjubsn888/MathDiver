package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
/**
 *
 * @author mju
 */
public class FrameHome extends JFrame {
    
    String userName;
    
    public FrameHome(String userName) {  
        
        this.userName=userName;
        initComponents();
        setLocationRelativeTo(null);        
        setVisible(true);
        
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
        
        jLabelUser.setText(userName);
        
    }   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelUser = new javax.swing.JLabel();
        jButtonK1 = new javax.swing.JButton();
        jButtonBack = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(640, 480));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jLabelUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, -1, -1));

        jButtonK1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Cameron\\Documents\\MathDiver-main\\src\\main\\java\\view\\images\\Slide2.JPG")); // NOI18N
        jButtonK1.setPreferredSize(new java.awt.Dimension(180, 180));
        getContentPane().add(jButtonK1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 270, 210, 200));

        jButtonBack.setIcon(new javax.swing.ImageIcon("C:\\Users\\Cameron\\Documents\\MathDiver-main\\src\\main\\java\\view\\images\\Slide1.JPG")); // NOI18N
        jButtonBack.setText("jButton1");
        jButtonBack.setPreferredSize(new java.awt.Dimension(150, 190));
        getContentPane().add(jButtonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 90, -1, -1));

        jButton23.setIcon(new javax.swing.ImageIcon("C:\\Users\\Cameron\\Documents\\MathDiver-main\\src\\main\\java\\view\\images\\23Porthole.JPG")); // NOI18N
        jButton23.setPreferredSize(new java.awt.Dimension(190, 190));
        getContentPane().add(jButton23, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 270, 220, 250));

        jButton4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Cameron\\Documents\\MathDiver-main\\src\\main\\java\\view\\images\\4Porthole.JPG")); // NOI18N
        jButton4.setPreferredSize(new java.awt.Dimension(180, 180));
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 270, 220, 240));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Cameron\\Documents\\MathDiver-main\\src\\main\\java\\view\\images\\Homepage.jpg")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonK1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelUser;
    // End of variables declaration//GEN-END:variables
}
