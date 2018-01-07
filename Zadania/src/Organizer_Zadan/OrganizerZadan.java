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
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author MatriX
 */
public class OrganizerZadan implements ActionListener {
   JTextField t1;
   JTextArea t2;
   JButton b1;
   JButton b2;
       public static void main(String[] args)          
   {                                               
      //do wersji 1.4                              
      //new Demo().init();                         
 
      //od wersji 1.5                              
      SwingUtilities.invokeLater(new Runnable()    
      {                                            
         @Override
         public void run()                         
         {                                         
            new OrganizerZadan().init();                     
         }                                         
      });                                          
   }      

    private void init() {
      JFrame f=new JFrame();                            
      Container c=f.getContentPane();
      
      GridBagLayout gbl=new GridBagLayout();                                    
      GridBagConstraints gbc=new GridBagConstraints();                          
      gbc.fill=GridBagConstraints.HORIZONTAL;                                   
      c.setLayout(gbl); 
 
      t1=new JTextField(20);
      t1.addActionListener(this);                       
      t1.setFocusable(false);                         
      gbc.gridx=0;                                                              
      gbc.gridy=0;                                                              
      gbc.gridwidth=1;                                                          
      gbc.ipadx=0;                                                              
      gbc.ipady=0;                                                              
      gbc.insets=new Insets(5,5,0,5);                                           
      gbl.setConstraints(t1,gbc);                                               
      c.add(t1);  
      
      t2=new JTextArea(20,20);
      t2.setFocusable(false);                                                   
      gbc.gridx=0;                                                              
      gbc.gridy=1;                                                              
      gbc.gridwidth=1;                                                          
      gbc.ipadx=0;                                                              
      gbc.ipady=0;                                                              
      gbc.insets=new Insets(5,5,0,0);                                           
      gbl.setConstraints(t2,gbc);                                               
      c.add(t2);  
      
      b1=new JButton("ADD");
      b1.addActionListener(this);                       
      b1.setFocusable(false);                                                   
      gbc.gridx=1;                                                              
      gbc.gridy=0;                                                              
      gbc.gridwidth=1;                                                          
      gbc.ipadx=0;                                                              
      gbc.ipady=0;                                                              
      gbc.insets=new Insets(5,5,5,0);                                           
      gbl.setConstraints(b1,gbc);                                               
      c.add(b1);  
      
      b2=new JButton("DELETE");
      b2.addActionListener(this);                       
      b1.setFocusable(false);                                                   
      gbc.gridx=2;                                                              
      gbc.gridy=0;                                                              
      gbc.gridwidth=1;                                                          
      gbc.ipadx=0;                                                              
      gbc.ipady=0;                                                              
      gbc.insets=new Insets(5,5,5,5);                                           
      gbl.setConstraints(b2,gbc);                                               
      c.add(b2);  
 
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
