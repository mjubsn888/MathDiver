package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;
import model.QuestionAddition;
import model.UIControlRadioButton;

/**
 *
 * @author mju
 */
public class FrameK1AdditionPractice extends JFrame {

    String answerCorrectIdx;
    String answerSelectedIdx;
    ButtonGroup rbGroup;
    String userName;

    public FrameK1AdditionPractice(String useName)  {
        //1.GUI components                
        initComponents();
        setLocationRelativeTo(null);        
        setVisible(true);

        //2, load image
        try{
            String strUrl="https://images2.imgbox.com/72/58/M7dZuydm_o.jpg";
            URL url=new URL(strUrl);

            Image image= ImageIO.read(url);
            ImageIcon imagebkg = new ImageIcon(image);
            jLabel10.setIcon(imagebkg);

        } catch (IOException e) {
            e.printStackTrace();
        }

        //load username
        this.userName=useName;        
        jLabelUser.setText(userName);
        
        //set math operator
        jLabelMathOperator1.setText("+");

        //3. add listener to buttons
        jButtonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameK1Subjects frameK1Subjects=new FrameK1Subjects(userName);
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
                    JOptionPane.showMessageDialog(jPanelAnswer, "Please select an answer and click submit!", "Warning", JOptionPane.WARNING_MESSAGE);
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
                    }
                    else {
                        //incorrect answer
                        jLabelAnswerStatus.setText("incorrect!!!");
                        jButtonShowRightAnswer.setEnabled(true);
                        jLabelRightAnswer.setText("");
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
        jLabel1.setText(q.getListParamsStr().get(1));
        jLabel2.setText(q.getListParamsStr().get(0));
        jLabelA.setText(q.getListAnswers().get(0).getContentTxt());
        jLabelB.setText(q.getListAnswers().get(1).getContentTxt());
        jLabelC.setText(q.getListAnswers().get(2).getContentTxt());
        jLabelD.setText(q.getListAnswers().get(3).getContentTxt());

        jButtonShowRightAnswer.setEnabled(false);
        jLabelRightAnswer.setText("");
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

        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabelUser = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButtonBack = new javax.swing.JButton();
        jPanelQuestion = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelMathOperator1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanelAnswer = new javax.swing.JPanel();
        jRadioButtonA = new javax.swing.JRadioButton();
        jRadioButtonB = new javax.swing.JRadioButton();
        jRadioButtonC = new javax.swing.JRadioButton();
        jRadioButtonD = new javax.swing.JRadioButton();
        jLabelA = new javax.swing.JLabel();
        jLabelB = new javax.swing.JLabel();
        jLabelC = new javax.swing.JLabel();
        jLabelD = new javax.swing.JLabel();
        jPanelAnswerControl = new javax.swing.JPanel();
        jButtonSubmit = new javax.swing.JButton();
        jLabelAnswerStatus = new javax.swing.JLabel();
        jButtonTryAnother = new javax.swing.JButton();
        jButtonShowRightAnswer = new javax.swing.JButton();
        jLabelRightAnswer = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(640, 480));
        setPreferredSize(new java.awt.Dimension(1280, 800));

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(240, 960));

        jLabel10.setText("jLabel10");

        jLabelUser.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelUser.setText("user");
        jLabelUser.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelUser, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabelUser, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(153, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(240, 960));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 174, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1020, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(0, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(800, 100));

        jButtonBack.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonBack.setText("Back");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanelQuestion.setBackground(new java.awt.Color(153, 255, 153));
        jPanelQuestion.setPreferredSize(new java.awt.Dimension(800, 200));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("8");

        jLabelMathOperator1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabelMathOperator1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMathOperator1.setText("-");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("2");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("=");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("?");

        javax.swing.GroupLayout jPanelQuestionLayout = new javax.swing.GroupLayout(jPanelQuestion);
        jPanelQuestion.setLayout(jPanelQuestionLayout);
        jPanelQuestionLayout.setHorizontalGroup(
            jPanelQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelQuestionLayout.createSequentialGroup()
                .addGap(205, 205, 205)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelMathOperator1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelQuestionLayout.setVerticalGroup(
            jPanelQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelQuestionLayout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(jPanelQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMathOperator1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100))
        );

        jPanelAnswer.setBackground(new java.awt.Color(0, 255, 255));
        jPanelAnswer.setPreferredSize(new java.awt.Dimension(800, 200));

        jRadioButtonA.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jRadioButtonA.setText("A");

        jRadioButtonB.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jRadioButtonB.setText("B");

        jRadioButtonC.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jRadioButtonC.setText("C");

        jRadioButtonD.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jRadioButtonD.setText("D");

        jLabelA.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabelA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelA.setText("6");

        jLabelB.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabelB.setText("5");

        jLabelC.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabelC.setText("3");

        jLabelD.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabelD.setText("2");

        javax.swing.GroupLayout jPanelAnswerLayout = new javax.swing.GroupLayout(jPanelAnswer);
        jPanelAnswer.setLayout(jPanelAnswerLayout);
        jPanelAnswerLayout.setHorizontalGroup(
            jPanelAnswerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAnswerLayout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addGroup(jPanelAnswerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanelAnswerLayout.createSequentialGroup()
                        .addComponent(jRadioButtonA, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jRadioButtonB, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelAnswerLayout.createSequentialGroup()
                        .addComponent(jLabelA, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(108, 108, 108)
                        .addComponent(jLabelB, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(67, 67, 67)
                .addGroup(jPanelAnswerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jRadioButtonC, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelC, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanelAnswerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAnswerLayout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jLabelD, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelAnswerLayout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jRadioButtonD, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(229, Short.MAX_VALUE))
        );
        jPanelAnswerLayout.setVerticalGroup(
            jPanelAnswerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAnswerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelAnswerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelA, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelB, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelC, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelD, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanelAnswerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonA)
                    .addComponent(jRadioButtonB)
                    .addComponent(jRadioButtonC)
                    .addComponent(jRadioButtonD))
                .addGap(73, 73, 73))
        );

        jPanelAnswerControl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanelAnswerControl.setPreferredSize(new java.awt.Dimension(800, 200));

        jButtonSubmit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonSubmit.setText("Submit");

        jLabelAnswerStatus.setText("no answer yet");
        jLabelAnswerStatus.setOpaque(true);

        jButtonTryAnother.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonTryAnother.setText("try another");

        jButtonShowRightAnswer.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonShowRightAnswer.setText("show right answer");

        jLabelRightAnswer.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelRightAnswer.setOpaque(true);

        javax.swing.GroupLayout jPanelAnswerControlLayout = new javax.swing.GroupLayout(jPanelAnswerControl);
        jPanelAnswerControl.setLayout(jPanelAnswerControlLayout);
        jPanelAnswerControlLayout.setHorizontalGroup(
            jPanelAnswerControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAnswerControlLayout.createSequentialGroup()
                .addGroup(jPanelAnswerControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabelRightAnswer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonShowRightAnswer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelAnswerControlLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelAnswerStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(197, 197, 197)
                .addComponent(jButtonSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonTryAnother)
                .addGap(90, 90, 90))
        );
        jPanelAnswerControlLayout.setVerticalGroup(
            jPanelAnswerControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAnswerControlLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelAnswerControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAnswerControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButtonSubmit, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                        .addComponent(jButtonTryAnother, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelAnswerControlLayout.createSequentialGroup()
                        .addComponent(jLabelAnswerStatus)
                        .addGap(30, 30, 30)
                        .addComponent(jButtonShowRightAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addComponent(jLabelRightAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelQuestion, javax.swing.GroupLayout.DEFAULT_SIZE, 896, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 896, Short.MAX_VALUE)
                    .addComponent(jPanelAnswer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 896, Short.MAX_VALUE)
                    .addComponent(jPanelAnswerControl, javax.swing.GroupLayout.DEFAULT_SIZE, 896, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1020, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1020, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelAnswerControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonShowRightAnswer;
    private javax.swing.JButton jButtonSubmit;
    private javax.swing.JButton jButtonTryAnother;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelA;
    private javax.swing.JLabel jLabelAnswerStatus;
    private javax.swing.JLabel jLabelB;
    private javax.swing.JLabel jLabelC;
    private javax.swing.JLabel jLabelD;
    private javax.swing.JLabel jLabelMathOperator1;
    private javax.swing.JLabel jLabelRightAnswer;
    private javax.swing.JLabel jLabelUser;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelAnswer;
    private javax.swing.JPanel jPanelAnswerControl;
    private javax.swing.JPanel jPanelQuestion;
    private javax.swing.JRadioButton jRadioButtonA;
    private javax.swing.JRadioButton jRadioButtonB;
    private javax.swing.JRadioButton jRadioButtonC;
    private javax.swing.JRadioButton jRadioButtonD;
    // End of variables declaration//GEN-END:variables
}
