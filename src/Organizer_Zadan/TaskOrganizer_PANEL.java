/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Organizer_Zadan;

import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 *Klasa, odpowiadająca za wygląd aplikacji oraz funkcji poszczególnych przycisków 
 *@author Mateusz Brodziak, Mateusz Olszewski
 *
 */
public class TaskOrganizer_PANEL extends javax.swing.JFrame {

    private static final long serialVersionUID = -4679833238790674239L;


    /**
     * Creates new form OrganizerZadan
     */
    public TaskOrganizer_PANEL() {
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
        jTable = new javax.swing.JTable();
        ADDButton = new javax.swing.JButton();
        ModifyButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        SaveButton = new javax.swing.JButton();
        LoadButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        AutoSaveCheckBox = new javax.swing.JCheckBox();
        LOGOUTButton = new javax.swing.JButton();
        ChnPssButton = new javax.swing.JButton();
        TodayLoadButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Organizer Zadań");
        setBackground(new java.awt.Color(0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(new java.awt.Color(0, 0, 0));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Where?", "What?", "Taken?"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.setColumnSelectionAllowed(true);
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable);
        jTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTable.getColumnModel().getColumnCount() > 0) {
            jTable.getColumnModel().getColumn(1).setResizable(false);
            jTable.getColumnModel().getColumn(3).setResizable(false);
        }
        jTable.getAccessibleContext().setAccessibleDescription("");

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

        LoadButton.setText("Load");
        LoadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Where?");

        jLabel3.setText("What?");

        jLabel4.setText("Date");

        AutoSaveCheckBox.setText("Autosave");
        AutoSaveCheckBox.setToolTipText("");
        AutoSaveCheckBox.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        LOGOUTButton.setText("LOG OUT");
        LOGOUTButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LOGOUTButtonActionPerformed(evt);
            }
        });

        ChnPssButton.setText("Change Password");
        ChnPssButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChnPssButtonActionPerformed(evt);
            }
        });

        TodayLoadButton.setText("Today Load");
        TodayLoadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TodayLoadButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LOGOUTButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ChnPssButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(AutoSaveCheckBox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(LoadButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TodayLoadButton, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(WhatField)
                                .addGap(12, 12, 12)
                                .addComponent(DeleteButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(ADDButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(WhereField)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ModifyButton)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4))
                                        .addGap(7, 7, 7)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel1)
                                            .addComponent(WhereField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(ADDButton)
                                        .addGap(29, 29, 29)))
                                .addGap(3, 3, 3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(ModifyButton)))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DeleteButton)
                            .addComponent(WhatField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SaveButton)
                            .addComponent(AutoSaveCheckBox))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LoadButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TodayLoadButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LOGOUTButton)
                            .addComponent(ChnPssButton))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  
    private void ADDButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDButtonActionPerformed
        try {
            SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-YYYY");
            String date = dFormat.format(jDateChooser.getDate());
            DefaultTableModel model = (DefaultTableModel) jTable.getModel();
            model.addRow(new Object[]{date, WhereField.getText(), WhatField.getText()});
        } catch (NullPointerException e) {
        }

    }//GEN-LAST:event_ADDButtonActionPerformed
    

    private void ModifyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModifyButtonActionPerformed
        try {
            SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
            String date = dFormat.format(jDateChooser.getDate());
            int ROW = jTable.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) jTable.getModel();
            model.removeRow(ROW);
            model.insertRow(ROW, new Object[]{date, WhereField.getText(), WhatField.getText()});
        } catch (NullPointerException e) {
        }
    }//GEN-LAST:event_ModifyButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        try {
            int ROW = jTable.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) jTable.getModel();
            model.removeRow(ROW);
        } catch (ArrayIndexOutOfBoundsException e) {
        }

    }//GEN-LAST:event_DeleteButtonActionPerformed


    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        try {
            DefaultTableModel model = (DefaultTableModel) jTable.getModel();
            SaveLoadSystem.save(model,AutoSaveCheckBox.isSelected());
        }  catch (NoSuchAlgorithmException | InvalidKeyException | IOException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException | ClassNotFoundException ex) {
        }
    }//GEN-LAST:event_SaveButtonActionPerformed


    private void LoadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoadButtonActionPerformed
        try {
            DefaultTableModel model = (DefaultTableModel) jTable.getModel();
            AutoSaveCheckBox.setSelected(SaveLoadSystem.load(model));
        } catch (IOException | ClassNotFoundException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
        }
    }//GEN-LAST:event_LoadButtonActionPerformed


    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            DefaultTableModel model = (DefaultTableModel) jTable.getModel();
            AutoSaveCheckBox.setSelected(SaveLoadSystem.load(model));
        } catch (IOException | ClassNotFoundException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
        }
    }//GEN-LAST:event_formWindowOpened


    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (AutoSaveCheckBox.isSelected()) {
            try {
                DefaultTableModel model = (DefaultTableModel) jTable.getModel();
                SaveLoadSystem.save(model,AutoSaveCheckBox.isSelected());
            } catch (IOException | NoSuchAlgorithmException | InvalidKeyException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException | ClassNotFoundException ex) {
            }
        }
    }//GEN-LAST:event_formWindowClosing


    private void LOGOUTButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LOGOUTButtonActionPerformed
        java.awt.EventQueue.invokeLater(() -> {
            new LogIn_PANEL().setVisible(true);
        });
        this.dispose();
    }//GEN-LAST:event_LOGOUTButtonActionPerformed


    private void ChnPssButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChnPssButtonActionPerformed
        java.awt.EventQueue.invokeLater(() -> {
            new ChangePassword_PANEL().setVisible(true);
            
        });
    }//GEN-LAST:event_ChnPssButtonActionPerformed

    
    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        try {
            SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
            int ROW = jTable.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) jTable.getModel();
            jDateChooser.setDate(dFormat.parse((String) model.getValueAt(ROW, 0)));
            WhereField.setText((String) model.getValueAt(ROW, 1));
            WhatField.setText((String) model.getValueAt(ROW, 2));
        } catch (ParseException ex) {
        }
    }//GEN-LAST:event_jTableMouseClicked


    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
            DefaultTableModel model = (DefaultTableModel) jTable.getModel();
            SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
            jDateChooser.cleanup();
            WhereField.setText("");
            WhatField.setText("");
    }//GEN-LAST:event_formMouseClicked


    private void TodayLoadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TodayLoadButtonActionPerformed
        try {
            DefaultTableModel model = (DefaultTableModel) jTable.getModel();
            SaveLoadSystem.todayLoad(model);
        } catch (IOException | ClassNotFoundException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
        }        
    }//GEN-LAST:event_TodayLoadButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADDButton;
    public static javax.swing.JCheckBox AutoSaveCheckBox;
    private javax.swing.JButton ChnPssButton;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton LOGOUTButton;
    private javax.swing.JButton LoadButton;
    private javax.swing.JButton ModifyButton;
    private javax.swing.JButton SaveButton;
    private javax.swing.JButton TodayLoadButton;
    private javax.swing.JTextField WhatField;
    private javax.swing.JTextField WhereField;
    private com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
}
