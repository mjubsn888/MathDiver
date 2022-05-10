package view.practice;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

import model.*;
import model.database.DBException;
import model.database.Practice;
import model.database.Reward;
import view.FrameActivityMenu;

/**
 *
 * @author mju
 */
public class FrameK1AdditionPractice extends JFrame {

    String userName;
    String subject;
    String level;
    
    String answerCorrectIdx;
    String answerSelectedIdx;
    String test_id="1a";
    Reward reward;

    ButtonGroup rbGroup;
    ToolImage toolImage;
    ImageIcon imageIcon;

    //int nbrCorrect=0;
    //int nbrTotal=0;

    public FrameK1AdditionPractice(String userName, String level, String subject) {
        //1.GUI components                
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
        
        //load username
        this.userName=userName;        
        jLabelUserName.setText(userName);
        this.subject=subject;
        jLabelSubject.setText(subject);
        this.level=level;
        
        //set math operator
        jLabelMathOperator1.setText("+");

        reward=new Reward();

        //3. add listener to buttons
        jButtonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    Practice.updatePractice(userName, test_id, reward.getNbrCorrect(), reward.getNbrTotal());
                } catch (DBException dbException) {
                    dbException.printStackTrace();
                }
                
                FrameActivityMenu frameActivityMenu=new FrameActivityMenu(userName, level, subject);

                //FrameK1Subjects frameK1Subjects=new FrameK1Subjects(userName);
                dispose();
            }
        });

        jButtonShowRightAnswer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s="x";
                jLabelRightAnswer.setVisible(true);
                jLabelRightAnswer.setText(answerCorrectIdx);
                jButtonShowRightAnswer.setEnabled(false);
            }
        });

        jButtonSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //1. get selected button text
                 answerSelectedIdx= UIControlRadioButton.getSelectedRadioButtonText(rbGroup);

                if(answerSelectedIdx.equals("")){
                    JOptionPane.showMessageDialog(jButtonSubmit, "Please select an answer and click submit!", "Warning", JOptionPane.WARNING_MESSAGE);
                }

                //2. not equal to null (a button is selected)
                if(!answerSelectedIdx.equals("")) {
                    jButtonSubmit.setEnabled(false);

                    //correct answer
                    if(answerSelectedIdx.equals(answerCorrectIdx)) //if the answer is correct
                    {
                        jLabelAnswerStatus.setText("correct!!!");
                        jButtonSubmit.setEnabled(false);
                        jButtonShowRightAnswer.setEnabled(false);
                        jLabelRightAnswer.setText("");
                        try {
                            reward.addQuestionAnswered(true, userName, level);
                        } catch (DBException dbException) {
                            dbException.printStackTrace();
                        }
                        //nbrCorrect+=1;
                        //nbrTotal+=1;
                    }
                    else {
                        //incorrect answer
                        jLabelAnswerStatus.setText("incorrect!!!");
                        jButtonShowRightAnswer.setEnabled(true);
                        jLabelRightAnswer.setText("");
                        try {
                            reward.addQuestionAnswered(false, userName, level);
                        } catch (DBException dbException) {
                            dbException.printStackTrace();
                        }
                        //nbrTotal+=1;
                    }
                    disableRadioButtonGroup();
                }
            }
        });

        jButtonTryAnother.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshControls();
            }
        });

        //4
        initControls();  
    }

    public void initControls(){
        rbGroup=new ButtonGroup();
        rbGroup.add(jRadioButtonA);
        rbGroup.add(jRadioButtonB);
        rbGroup.add(jRadioButtonC);
        rbGroup.add(jRadioButtonD);

        refreshControls();
    }

    public void refreshControls(){
        QuestionAddition q=new QuestionAddition();
        answerCorrectIdx=q.getAnswerCorrect().getIdx();
        jLabelQuestion1.setText(q.getListParamsStr().get(1));
        jLabelQuestion2.setText(q.getListParamsStr().get(0));
        jLabelAnswerA.setText(q.getListAnswers().get(0).getContentTxt());
        jLabelAnswerB.setText(q.getListAnswers().get(1).getContentTxt());
        jLabelAnswerC.setText(q.getListAnswers().get(2).getContentTxt());
        jLabelAnswerD.setText(q.getListAnswers().get(3).getContentTxt());

        jButtonShowRightAnswer.setEnabled(false);
        jLabelRightAnswer.setText("");
        //jButtonSubmit.setVisible(true);
        jButtonSubmit.setEnabled(true);

        enableRadioButtonGroup();
        rbGroup.clearSelection();

        jLabelAnswerStatus.setText("no answer yet");
    }

    public void enableRadioButtonGroup(){
        jRadioButtonA.setEnabled(true);
        jRadioButtonB.setEnabled(true);
        jRadioButtonC.setEnabled(true);
        jRadioButtonD.setEnabled(true);
    }

    public void disableRadioButtonGroup(){
        jRadioButtonA.setEnabled(false);
        jRadioButtonB.setEnabled(false);
        jRadioButtonC.setEnabled(false);
        jRadioButtonD.setEnabled(false);
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonTryAnother = new javax.swing.JButton();
        jLabelUserName = new javax.swing.JLabel();
        jButtonBack = new javax.swing.JButton();
        jLabelQuestion1 = new javax.swing.JLabel();
        jLabelMathOperator1 = new javax.swing.JLabel();
        jLabelQuestion2 = new javax.swing.JLabel();
        jLabelMathOperator2 = new javax.swing.JLabel();
        jLabelQuestion3 = new javax.swing.JLabel();
        jLabelAnswerA = new javax.swing.JLabel();
        jLabelAnswerB = new javax.swing.JLabel();
        jLabelAnswerC = new javax.swing.JLabel();
        jLabelAnswerD = new javax.swing.JLabel();
        jRadioButtonA = new javax.swing.JRadioButton();
        jRadioButtonB = new javax.swing.JRadioButton();
        jRadioButtonC = new javax.swing.JRadioButton();
        jRadioButtonD = new javax.swing.JRadioButton();
        jButtonShowRightAnswer = new javax.swing.JButton();
        jLabelAnswerStatus = new javax.swing.JLabel();
        jLabelRightAnswer = new javax.swing.JLabel();
        jButtonSubmit = new javax.swing.JButton();
        jLabelBackground = new javax.swing.JLabel();
        jLabelSubject = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonTryAnother.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonTryAnother.setText("try another");
        getContentPane().add(jButtonTryAnother, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 440, -1, 60));

        jLabelUserName.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelUserName.setText("user");
        jLabelUserName.setToolTipText("");
        getContentPane().add(jLabelUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 85, 41));

        jButtonBack.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonBack.setMaximumSize(new java.awt.Dimension(120, 80));
        getContentPane().add(jButtonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(955, 40, 80, 120));

        jLabelQuestion1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabelQuestion1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelQuestion1.setText("8");
        getContentPane().add(jLabelQuestion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, 60, 51));

        jLabelMathOperator1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabelMathOperator1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMathOperator1.setText("op");
        getContentPane().add(jLabelMathOperator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, 60, 60));

        jLabelQuestion2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabelQuestion2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelQuestion2.setText("2");
        getContentPane().add(jLabelQuestion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 100, 60, 60));

        jLabelMathOperator2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabelMathOperator2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMathOperator2.setText("=");
        getContentPane().add(jLabelMathOperator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 100, 60, 60));

        jLabelQuestion3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabelQuestion3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelQuestion3.setText("?");
        getContentPane().add(jLabelQuestion3, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 100, 60, 60));

        jLabelAnswerA.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabelAnswerA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAnswerA.setText("6");
        getContentPane().add(jLabelAnswerA, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, 60, 60));

        jLabelAnswerB.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabelAnswerB.setText("5");
        getContentPane().add(jLabelAnswerB, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 210, 60, 60));

        jLabelAnswerC.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabelAnswerC.setText("3");
        getContentPane().add(jLabelAnswerC, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 210, 60, 60));

        jLabelAnswerD.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabelAnswerD.setText("2");
        getContentPane().add(jLabelAnswerD, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 210, 60, 60));

        jRadioButtonA.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jRadioButtonA.setText("A");
        getContentPane().add(jRadioButtonA, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 340, 80, -1));

        jRadioButtonB.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jRadioButtonB.setText("B");
        getContentPane().add(jRadioButtonB, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 340, 80, -1));

        jRadioButtonC.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jRadioButtonC.setText("C");
        getContentPane().add(jRadioButtonC, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 340, 80, -1));

        jRadioButtonD.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jRadioButtonD.setText("D");
        getContentPane().add(jRadioButtonD, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 340, 60, -1));

        jButtonShowRightAnswer.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonShowRightAnswer.setText("show right answer");
        getContentPane().add(jButtonShowRightAnswer, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 510, 150, 61));

        jLabelAnswerStatus.setText("no answer yet");
        jLabelAnswerStatus.setOpaque(true);
        getContentPane().add(jLabelAnswerStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 450, 148, -1));

        jLabelRightAnswer.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelRightAnswer.setOpaque(true);
        getContentPane().add(jLabelRightAnswer, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 510, 90, 60));

        jButtonSubmit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonSubmit.setText("Submit");
        getContentPane().add(jButtonSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 440, 116, 60));

        jLabelBackground.setText("background-test.jpg");
        getContentPane().add(jLabelBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabelSubject.setText("subject");
        jLabelSubject.setToolTipText("");
        getContentPane().add(jLabelSubject, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 190, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonShowRightAnswer;
    private javax.swing.JButton jButtonSubmit;
    private javax.swing.JButton jButtonTryAnother;
    private javax.swing.JLabel jLabelAnswerA;
    private javax.swing.JLabel jLabelAnswerB;
    private javax.swing.JLabel jLabelAnswerC;
    private javax.swing.JLabel jLabelAnswerD;
    private javax.swing.JLabel jLabelAnswerStatus;
    private javax.swing.JLabel jLabelBackground;
    private javax.swing.JLabel jLabelMathOperator1;
    private javax.swing.JLabel jLabelMathOperator2;
    private javax.swing.JLabel jLabelQuestion1;
    private javax.swing.JLabel jLabelQuestion2;
    private javax.swing.JLabel jLabelQuestion3;
    private javax.swing.JLabel jLabelRightAnswer;
    private javax.swing.JLabel jLabelSubject;
    private javax.swing.JLabel jLabelUserName;
    private javax.swing.JRadioButton jRadioButtonA;
    private javax.swing.JRadioButton jRadioButtonB;
    private javax.swing.JRadioButton jRadioButtonC;
    private javax.swing.JRadioButton jRadioButtonD;
    // End of variables declaration//GEN-END:variables
}
