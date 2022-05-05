package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
/**
 *
 * @author mju
 */
public class FrameK1AdditionMenu extends JFrame {
    
    String userName;
    
    public FrameK1AdditionMenu(String userName) {  
        
        this.userName=userName;
        initComponents();
        setLocationRelativeTo(null);        
        setVisible(true);
        
        jButtonPractice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
             FrameK1AdditionPractice frameK1PracticeAddition=new FrameK1AdditionPractice(userName);
                
             dispose(); 
            }
        });
        
        jButtonTest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
             FrameK1AdditionTest frameK1TestAddition=new FrameK1AdditionTest(userName);
             
                
             dispose();
            }
        });
        
        jButtonTutorial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
             FrameK1AdditionTutorial frameK1TutorialAddition=new FrameK1AdditionTutorial(userName);
             
                
             dispose();
            }
        });
        
        jButtonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameK1Subjects frameK1=new FrameK1Subjects(userName);
                dispose(); 
            }
        });
        
        jLabelUser.setText(userName);
        
    }   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jButtonPractice = new javax.swing.JButton();
        jButtonTest = new javax.swing.JButton();
        jButtonTutorial = new javax.swing.JButton();
        jButtonBack = new javax.swing.JButton();
        jLabelUser = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(640, 480));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setText("Addition");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, 140, 40));

        jButtonPractice.setText("Practice");
        getContentPane().add(jButtonPractice, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 160, -1, -1));

        jButtonTest.setText("Test");
        getContentPane().add(jButtonTest, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 280, -1, -1));

        jButtonTutorial.setText("Tutorial");
        getContentPane().add(jButtonTutorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 420, -1, -1));

        jButtonBack.setIcon(new javax.swing.ImageIcon("C:\\Users\\Cameron\\Documents\\MathDiver-main\\src\\main\\java\\view\\images\\Slide1.JPG")); // NOI18N
        jButtonBack.setPreferredSize(new java.awt.Dimension(150, 180));
        getContentPane().add(jButtonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 30, -1, 200));
        getContentPane().add(jLabelUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 450, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Cameron\\Documents\\MathDiver-main\\src\\main\\java\\view\\images\\K-1PageImage.jpg")); // NOI18N
        jLabel1.setAlignmentY(0.0F);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonPractice;
    private javax.swing.JButton jButtonTest;
    private javax.swing.JButton jButtonTutorial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelUser;
    // End of variables declaration//GEN-END:variables
}
