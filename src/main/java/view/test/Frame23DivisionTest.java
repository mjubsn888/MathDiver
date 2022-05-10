package view.test;

import model.*;
import model.database.DBException;
import model.database.Reward;
import model.database.Test;
import view.FrameActivityMenu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;

/**
 *
 * @author mju
 */
public class Frame23DivisionTest extends JFrame {
    String userName;
    String subject;
    String level;

    String strCountInProgress;
    String strCountCompleted;
    String answerCorrectIdx;
    String answerSelectedIdx;
    String test_id="2d";
    Reward reward;

    int nbrOfQuestions;
    int idxQuestionCurrent;
    int progressBarMinValue;
    int progressBarMaxValue;

    TestMath testMath;
    ArrayList<QuestionDivision> listQuestion;
    ArrayList<String> listAnswer;

    QuestionDivision q;
    ToolAnswerDivision toolAnswerDivision;

    ButtonGroup rbGroup;
    ToolImage toolImage;
    ImageIcon imageIcon;

    //int nbrCorrect=0;
    //int nbrTotal=0;

    public Frame23DivisionTest(String userName, String level, String subject) {
        //1.GUI components                
        initComponents();
        setLocationRelativeTo(null);        
        setVisible(true);
        jButtonNewTest.setEnabled(false);

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

        testMath =new TestMath();
        nbrOfQuestions= testMath.getNbrOfQuestions();

        //create questions based on the number of questions
        listQuestion=new ArrayList<>();
        listAnswer=new ArrayList<>();
        for (int i = 0; i < nbrOfQuestions; i++) {
            listQuestion.add(new QuestionDivision());
            listAnswer.add("U");
        }

        jLabelCount.setText(Integer.toString(nbrOfQuestions));

        //set 1st question
        idxQuestionCurrent=0;
        refreshControlsQuestions(idxQuestionCurrent);
        jButtonPrevious.setEnabled(false);

        strCountInProgress=Integer.toString(idxQuestionCurrent+1)+"/"+Integer.toString(nbrOfQuestions);
        jLabelCount.setText(strCountInProgress);

        //reward=new Reward();
        //3. add listener to buttons

        jButtonNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveToListAnswer(idxQuestionCurrent);
                //go to next question
                jButtonPrevious.setEnabled(true);
                if(idxQuestionCurrent<nbrOfQuestions-1) {
                    idxQuestionCurrent++;
                    refreshControlsQuestions(idxQuestionCurrent);
                    reloadAnswerAlreadyChosen(idxQuestionCurrent);

                    strCountInProgress=Integer.toString(idxQuestionCurrent+1)+"/"+Integer.toString(nbrOfQuestions);
                    jLabelCount.setText(strCountInProgress);
                }
                if(idxQuestionCurrent>=nbrOfQuestions-1){
                    jButtonNext.setEnabled(false);
                }
            }
        });

        jButtonPrevious.addActionListener(new ActionListener() {//previous question
            @Override
            public void actionPerformed(ActionEvent e) {
                saveToListAnswer(idxQuestionCurrent);
                jButtonNext.setEnabled(true);
                if(idxQuestionCurrent>0) {
                    idxQuestionCurrent--;
                    refreshControlsQuestions(idxQuestionCurrent);
                    reloadAnswerAlreadyChosen(idxQuestionCurrent);
                    strCountInProgress=Integer.toString(idxQuestionCurrent+1)+"/"+Integer.toString(nbrOfQuestions);
                    jLabelCount.setText(strCountInProgress);
                }
                if(idxQuestionCurrent<=0){
                    jButtonPrevious.setEnabled(false);
                }
            }
        });

        jButtonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameActivityMenu frameActivityMenu=new FrameActivityMenu(userName, level, subject);
                dispose();
            }
        });

        jButtonSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveToListAnswer(idxQuestionCurrent);

                String msg="Do you want to submit all your answers?";

                int option= JOptionPane.showConfirmDialog(null, msg);

                if(option==JOptionPane.YES_OPTION){
                    toolAnswerDivision=new ToolAnswerDivision(listAnswer, listQuestion);
                    try {
                        Test.resetTest(userName,test_id);
                        Test.updateTest(userName, test_id, toolAnswerDivision.getNbrCorrect(), toolAnswerDivision.getNbrTotal());
                    } catch (DBException dbException) {
                        dbException.printStackTrace();
                    }
                    jButtonSubmit.setEnabled(false);
                    jButtonNext.setEnabled(false);
                    jButtonPrevious.setEnabled(false);
                    jButtonNewTest.setEnabled(true);
                    jButtonNewTest.setText("test again");

                    strCountCompleted=Integer.toString(toolAnswerDivision.getNbrCorrect())+" correct out of "+Integer.toString(nbrOfQuestions);
                    jLabelCount.setText(strCountCompleted);

                }
            }
        });

        jButtonNewTest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Frame23DivisionTest frame23DivisionTest=new Frame23DivisionTest(userName, level, subject);
                dispose();
            }
        });
        //4
        initControls();  
    }

    public void saveToListAnswer(int idxQuestionCurrent) {
        String strChoice = UIControlRadioButton.getSelectedRadioButtonText(rbGroup); //A. B. C. D
        answerCorrectIdx = listQuestion.get(idxQuestionCurrent).getAnswerCorrect().getIdx();

        if (strChoice.equals("")) {
            strChoice = "U";
        }
        listAnswer.set(idxQuestionCurrent, strChoice);
    }


    public void reloadAnswerAlreadyChosen(int idxQuestionCurrent)
    {
        String strChosen=listAnswer.get(idxQuestionCurrent);
        rbGroup.clearSelection();
        switch (strChosen) {
            case "A" -> jRadioButtonA.setSelected(true);
            case "B" -> jRadioButtonB.setSelected(true);
            case "C" -> jRadioButtonC.setSelected(true);
            case "D" -> jRadioButtonD.setSelected(true);
            default -> rbGroup.clearSelection();
        }
    }

    public void initControls(){

        rbGroup=new ButtonGroup();
        rbGroup.add(jRadioButtonA);
        rbGroup.add(jRadioButtonB);
        rbGroup.add(jRadioButtonC);
        rbGroup.add(jRadioButtonD);

    }

    public void refreshControlsQuestions(int idxQuestionCurrent) {
        q = listQuestion.get(idxQuestionCurrent);
        jLabelQuestion1.setText(q.getListParamsStr().get(1));
        jLabelQuestion2.setText(q.getListParamsStr().get(0));
        jLabelAnswerA.setText(q.getListAnswers().get(0).getContentTxt());
        jLabelAnswerB.setText(q.getListAnswers().get(1).getContentTxt());
        jLabelAnswerC.setText(q.getListAnswers().get(2).getContentTxt());
        jLabelAnswerD.setText(q.getListAnswers().get(3).getContentTxt());
        jLabelMathOperator1.setText("/");
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

        jButtonNewTest = new javax.swing.JButton();
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
        jButtonPrevious = new javax.swing.JButton();
        jButtonSubmit = new javax.swing.JButton();
        jLabelSubject = new javax.swing.JLabel();
        jLabelCount = new javax.swing.JLabel();
        jButtonNext = new javax.swing.JButton();
        jLabelBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonNewTest.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(jButtonNewTest, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 430, 120, 60));

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

        jButtonPrevious.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonPrevious.setText("previous");
        getContentPane().add(jButtonPrevious, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 430, 110, 61));

        jButtonSubmit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonSubmit.setText("submit all");
        getContentPane().add(jButtonSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 430, 110, 60));

        jLabelSubject.setText("subject");
        jLabelSubject.setToolTipText("");
        getContentPane().add(jLabelSubject, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 190, 60));

        jLabelCount.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabelCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 150, 50));

        jButtonNext.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonNext.setText("next");
        getContentPane().add(jButtonNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 430, 100, 60));

        jLabelBackground.setText("background-test.jpg");
        getContentPane().add(jLabelBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonNewTest;
    private javax.swing.JButton jButtonNext;
    private javax.swing.JButton jButtonPrevious;
    private javax.swing.JButton jButtonSubmit;
    private javax.swing.JLabel jLabelAnswerA;
    private javax.swing.JLabel jLabelAnswerB;
    private javax.swing.JLabel jLabelAnswerC;
    private javax.swing.JLabel jLabelAnswerD;
    private javax.swing.JLabel jLabelBackground;
    private javax.swing.JLabel jLabelCount;
    private javax.swing.JLabel jLabelMathOperator1;
    private javax.swing.JLabel jLabelMathOperator2;
    private javax.swing.JLabel jLabelQuestion1;
    private javax.swing.JLabel jLabelQuestion2;
    private javax.swing.JLabel jLabelQuestion3;
    private javax.swing.JLabel jLabelSubject;
    private javax.swing.JLabel jLabelUserName;
    private javax.swing.JRadioButton jRadioButtonA;
    private javax.swing.JRadioButton jRadioButtonB;
    private javax.swing.JRadioButton jRadioButtonC;
    private javax.swing.JRadioButton jRadioButtonD;
    // End of variables declaration//GEN-END:variables
}
