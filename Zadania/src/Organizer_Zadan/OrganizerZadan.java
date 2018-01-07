/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Organizer_Zadan;

import javax.swing.SwingUtilities;

/**
 *
 * @author MatriX
 */
public class OrganizerZadan {
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
      b1=new JButton("^2");                             
      b2=new JButton("clear");
    }
    
}
