/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Organizer_Zadan;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.IOException;


/**
 *
 * 
 * 
 *
 */
public class OrganizerZadan extends javax.swing.JFrame {

    private static final long serialVersionUID = -4679833238790674239L;
    //String gdzie[] = new String[100]; 
    //String co[] = new String[100];

    /**
     * Creates new form OrganizerZadan
     */
    public OrganizerZadan() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooser = new com.toedter.calendar.JDateChooser();
        WhereField = new javax.swing.JTextField();
        WhatField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        ADDButton = new javax.swing.JButton();
        ModifyButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        SaveButton = new javax.swing.JButton();
        Load = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        WhereField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WhereFieldActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Gdzie?", "Co?", "Wykonano?"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        ADDButton.setText("ADD");
        ADDButton.setActionCommand("ADDButton");
        ADDButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDButtonActionPerformed(evt);
            }
        });

        ModifyButton.setText("Modify");
        ModifyButton.setActionCommand("ModifyButton");
        ModifyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifyButtonActionPerformed(evt);
            }
        });

        DeleteButton.setText("Delete");
        DeleteButton.setActionCommand("DeleteButton");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        SaveButton.setText("Save");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        Load.setText("Load");
        Load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addComponent(WhereField)
                    .addComponent(WhatField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ADDButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ModifyButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DeleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SaveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Load, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ADDButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(WhereField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ModifyButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(WhatField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DeleteButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SaveButton)
                        .addGap(18, 18, 18)
                        .addComponent(Load)))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void WhereFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WhereFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_WhereFieldActionPerformed

    private void ADDButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDButtonActionPerformed
        SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-YYYY");
        String date = dFormat.format(jDateChooser.getDate());
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[]{date, WhereField.getText(), WhatField.getText()});
       
    }//GEN-LAST:event_ADDButtonActionPerformed

    private void ModifyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModifyButtonActionPerformed
        SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
        String date = dFormat.format(jDateChooser.getDate());
        int ROW = jTable1.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.removeRow(ROW);
        model.insertRow(ROW, new Object[]{date, WhereField.getText(), WhatField.getText()});
    }//GEN-LAST:event_ModifyButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        int ROW = jTable1.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.removeRow(ROW);
        
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-YYYY");
        String date = dFormat.format(jDateChooser.getDate());
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        try {
            Zapis();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OrganizerZadan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void LoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoadActionPerformed
        try {
            Odczyt();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OrganizerZadan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(OrganizerZadan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_LoadActionPerformed

    private void Zapis() throws FileNotFoundException{
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int ile = model.getRowCount();
        int ilecol = model.getColumnCount();
        try(PrintWriter zapis = new PrintWriter("user.save")) {
            for (int i = 0; i < ile; i++){
                zapis.print(model.getValueAt(i, 0));
                zapis.print(", ");
                zapis.print(model.getValueAt(i, 1));
                zapis.print(", ");
                zapis.print(model.getValueAt(i, 2));
                zapis.print(", ");
                if(model.getValueAt(i, 3) == null){
                    model.setValueAt(false, i, 3);
                }
                zapis.println(model.getValueAt(i, 3));
                }
             zapis.print("#");
             zapis.close();
        }
    }
    
    private void Odczyt() throws FileNotFoundException, IOException{
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        BufferedReader in = new BufferedReader(new FileReader("user.save"));
        String czyt = in.readLine();
        System.out.println(czyt);
        while(!czyt.equals('#')){
            String[] podzial = czyt.split(", ");
            boolean bool = Boolean.parseBoolean(podzial[3]);
            model.addRow(new Object[]{podzial[0], podzial[1], podzial[2], bool});
            System.out.println(podzial[0]);
            System.out.println(podzial[1]);
            System.out.println(podzial[2]);
            System.out.println(podzial[3]);
            czyt = in.readLine();
            System.out.println(czyt);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADDButton;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton Load;
    private javax.swing.JButton ModifyButton;
    private javax.swing.JButton SaveButton;
    private javax.swing.JTextField WhatField;
    private javax.swing.JTextField WhereField;
    private com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
