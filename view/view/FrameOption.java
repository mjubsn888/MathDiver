/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import model.UIControlRadioButton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author mju
 */
public class FrameOption extends javax.swing.JFrame {

    String subject;
    ButtonGroup rbGroup;
    String strRadioButtonSelected;
    String userName;

    public FrameOption(String userName, String subject) {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //close JFrame without terminating the program

        rbGroup=new ButtonGroup();
        rbGroup.add(jRadioButtonPractice);
        rbGroup.add(jRadioButtonTest);

        jButtonYes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                strRadioButtonSelected= UIControlRadioButton.getSelectedRadioButtonText(rbGroup);
                if(strRadioButtonSelected.equals("practice")) {
                    if (subject.equals("addition")) {
                        FrameK1AdditionPractice frameK1AdditionPractice = new FrameK1AdditionPractice(userName);
                        dispose();
                    }
                    if (subject.equals("subtraction")) {
                        FrameK1SubtractionPractice frameK1SubtractionPractice = new FrameK1SubtractionPractice(userName);
                        dispose();
                    }
                }
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

        jRadioButtonPractice = new javax.swing.JRadioButton();
        jRadioButtonTest = new javax.swing.JRadioButton();
        jButtonYes = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(300, 300));

        jRadioButtonPractice.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jRadioButtonPractice.setText("practice");

        jRadioButtonTest.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jRadioButtonTest.setText("test");

        jButtonYes.setText("select");

        jButton1.setText("cancel");

        jRadioButton1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jRadioButton1.setText("tutorial");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jButtonYes)
                        .addGap(34, 34, 34)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButtonTest, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButtonPractice)
                            .addComponent(jRadioButton1))))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jRadioButtonPractice)
                .addGap(18, 18, 18)
                .addComponent(jRadioButtonTest)
                .addGap(27, 27, 27)
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonYes, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonYes;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButtonPractice;
    private javax.swing.JRadioButton jRadioButtonTest;
    // End of variables declaration//GEN-END:variables
}