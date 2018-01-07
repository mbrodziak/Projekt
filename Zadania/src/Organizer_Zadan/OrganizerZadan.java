/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Organizer_Zadan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author MatriX
 */
public class OrganizerZadan implements ActionListener {
   JTextField t1;
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
      t1=new JTextField(6);                             
      b1=new JButton("ADD");                             
      b2=new JButton("DELETE");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
