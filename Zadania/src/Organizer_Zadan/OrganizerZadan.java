/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Organizer_Zadan;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 *
 *
 */
public class OrganizerZadan implements ActionListener {
   JTextField Pole;
   JTextArea Pole2;
   JButton Przycisk;
   JButton Przycisk2;
   JButton Przycisk3;


    public void init() {
      JFrame f = new JFrame();                            
      Container c = f.getContentPane();
      
      GridBagLayout gbl = new GridBagLayout();                                    
      GridBagConstraints gbc = new GridBagConstraints();                          
      gbc.fill = GridBagConstraints.HORIZONTAL;                                   
      c.setLayout(gbl); 
      
      
 
      Pole = new JTextField(20);
      Pole.addActionListener(this);                       
      Pole.setFocusable(false);                         
      gbc.gridx = 0;                                                              
      gbc.gridy = 0;                                                              
      gbc.gridwidth = 1;                                                          
      gbc.ipadx = 0;                                                              
      gbc.ipady = 0;                                                              
      gbc.insets = new Insets(5,5,0,0);                                           
      gbl.setConstraints(Pole, gbc);                                               
      c.add(Pole);  
      
      Pole2 = new JTextArea(20,20);
      Pole2.setFocusable(false);                                                   
      gbc.gridx = 0;                                                              
      gbc.gridy = 1;                                                              
      gbc.gridwidth = 1;                                                          
      gbc.ipadx = 0;                                                              
      gbc.ipady = 0;                                                              
      gbc.insets = new Insets(5,5,0,0);                                           
      gbl.setConstraints(Pole2, gbc);                                               
      c.add(Pole2);  
      
      Przycisk = new JButton("ADD");
      Przycisk.addActionListener(this);                       
      Przycisk.setFocusable(false);                                                   
      gbc.gridx = 1;                                                              
      gbc.gridy = 0;                                                              
      gbc.gridwidth = 1;                                                          
      gbc.ipadx = 0;                                                              
      gbc.ipady = 0;                                                              
      gbc.insets = new Insets(5,5,5,0);                                           
      gbl.setConstraints(Przycisk, gbc);                                               
      c.add(Przycisk);  
      
      Przycisk2 = new JButton("DELETE");
      Przycisk2.addActionListener(this);                       
      Przycisk2.setFocusable(false);                                                   
      gbc.gridx = 2;                                                              
      gbc.gridy = 0;                                                              
      gbc.gridwidth = 1;                                                          
      gbc.ipadx = 0;                                                              
      gbc.ipady = 0;                                                              
      gbc.insets = new Insets(5,5,5,5);                                           
      gbl.setConstraints(Przycisk2, gbc);                                               
      c.add(Przycisk2);
      
      Przycisk3 = new JButton("Back");
      Przycisk3.addActionListener(this);
      Przycisk3.setFocusable(false);
      gbc.gridx = 3;
      gbc.gridy = 0;
      gbc.gridwidth = 1;
      gbc.ipadx = 0;
      gbc.ipady = 0;
      gbc.insets = new Insets(5,5,5,5);
      gbl.setConstraints(Przycisk3, gbc); 
      c.add(Przycisk3);
      
      
 
      f.pack();                                         
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
      f.setTitle("Organizer Zadan");
      f.setVisible(true); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object target = e.getSource(); 
    }
    
}
