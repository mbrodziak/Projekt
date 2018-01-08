/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Organizer_Zadan;

import javax.swing.SwingUtilities;

/**
 *
 * @author student
 */
public class Main {
    public static void main(String[] args) {         
        SwingUtilities.invokeLater(new OrganizerZadan()::init);
    }
}
