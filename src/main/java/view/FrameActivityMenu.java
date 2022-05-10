/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

import model.ImageReference;
import model.ToolImage;
import view.practice.Frame23DivisionPractice;
import view.practice.Frame23MultiplicationPractice;
import view.practice.FrameK1AdditionPractice;
import view.practice.FrameK1SubtractionPractice;
import view.test.Frame23DivisionTest;
import view.test.Frame23MultiplicationTest;
import view.test.FrameK1AdditionTest;
import view.test.FrameK1SubtractionTest;

/**
 *
 * @author Cameron
 */
public class FrameActivityMenu extends javax.swing.JFrame {

    String level;
    String subject;
    String userName;
    ToolImage toolImage;
    ImageIcon imageIcon;

    public FrameActivityMenu(String userName, String level, String subject) {
        initComponents();
        setLocationRelativeTo(null);        
        setVisible(true);
        
        //load username
        this.userName=userName;        
        jLabelUserName.setText(userName);
        this.subject=subject;
        jLabelSubject.setText(subject);
        this.level=level;

        //load image
        try {
            toolImage = new ToolImage();
            for (ImageReference imageRef : toolImage.getListImageReference()) {
                if (imageRef.getImageName().equals("standard-k1-1280x720.jpg") && level.equals("k1")) {
                    imageIcon = new ImageIcon(ImageIO.read(new URL(imageRef.getStrUrl())));
                    jLabelBackground.setIcon(imageIcon);
                }
                if (imageRef.getImageName().equals("standard-23-1280x720.jpg") && level.equals("23")) {
                    imageIcon = new ImageIcon(ImageIO.read(new URL(imageRef.getStrUrl())));
                    jLabelBackground.setIcon(imageIcon);
                }
                if (imageRef.getImageName().equals("standard-4-1280x720.jpg") && level.equals("4")) {
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
        
        jButtonPractice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(subject.equals("Addition")){
                    FrameK1AdditionPractice frameK1AdditionPractice=new FrameK1AdditionPractice(userName,level, subject);
                }
                if(subject.equals("Subtraction")){
                    FrameK1SubtractionPractice frameK1SubtractionPractice=new FrameK1SubtractionPractice(userName, level, subject);
                }
                if(subject.equals("Multiplication")){
                    Frame23MultiplicationPractice frame23MultiplicationPractice=new Frame23MultiplicationPractice(userName, level, subject);
                }
                if(subject.equals("Division")){
                    Frame23DivisionPractice frame23DivisionPractice=new Frame23DivisionPractice(userName, level, subject);
                }
                dispose();
            }
        });
        
        jButtonTest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(subject.equals("Addition")){
                    FrameK1AdditionTest frameK1AdditionTest=new FrameK1AdditionTest(userName,level, subject);
                    dispose();
                }
                if(subject.equals("Subtraction")){
                    FrameK1SubtractionTest frameK1SubtractionTest=new FrameK1SubtractionTest(userName, level, subject);
                }
                if(subject.equals("Multiplication")){
                    Frame23MultiplicationTest frame23MultiplicationTest=new Frame23MultiplicationTest(userName, level, subject);
                }
                if(subject.equals("Division")){
                    Frame23DivisionTest frame23DivisionTes=new Frame23DivisionTest(userName, level, subject);
                }
            }
        });
        
        jButtonTutorial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(level.equals("k1")){
                    FrameK1Tutorial frameK1Tutorial=new FrameK1Tutorial(userName,level, subject);
                    dispose();
                }
                if(level.equals("23")){
                    Frame23Tutorial frame23Tutorial=new Frame23Tutorial(userName,level, subject);
                    dispose();
                }
                if(level.equals("4")){
                    Frame4Tutorial frame4Tutorial=new Frame4Tutorial(userName,level, subject);
                    dispose();
                }
                
             //Frame23Subject1Tutorial frame23TutorialSubject1=new Frame23Subject1Tutorial(userName);
             
                
             //dispose();
            }
        });
        
        jButtonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {          
                if(subject.equals("Addition")||subject.equals("Subtraction")||subject.equals("counting"))
                {
                FrameK1Subjects frameK1Subjects=new FrameK1Subjects(userName);
                }
                
                dispose(); 
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelSubject = new javax.swing.JLabel();
        jButtonPractice = new javax.swing.JButton();
        jButtonTest = new javax.swing.JButton();
        jButtonTutorial = new javax.swing.JButton();
        jButtonBack = new javax.swing.JButton();
        jLabelUserName = new javax.swing.JLabel();
        jLabelBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelSubject.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabelSubject.setText("Subject 1");
        getContentPane().add(jLabelSubject, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 70, -1, -1));

        jButtonPractice.setText("Practice");
        getContentPane().add(jButtonPractice, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 180, -1, -1));

        jButtonTest.setText("Test");
        getContentPane().add(jButtonTest, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 270, 70, -1));

        jButtonTutorial.setText("Tutorial");
        getContentPane().add(jButtonTutorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 370, -1, -1));

        jButtonBack.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonBack.setMaximumSize(new java.awt.Dimension(120, 80));
        getContentPane().add(jButtonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 60, 80, 120));

        jLabelUserName.setText("username");
        getContentPane().add(jLabelUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 81, -1, -1));

        jLabelBackground.setText("background-test.jpg");
        getContentPane().add(jLabelBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonPractice;
    private javax.swing.JButton jButtonTest;
    private javax.swing.JButton jButtonTutorial;
    private javax.swing.JLabel jLabelBackground;
    private javax.swing.JLabel jLabelSubject;
    private javax.swing.JLabel jLabelUserName;
    // End of variables declaration//GEN-END:variables
}
