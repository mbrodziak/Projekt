/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Organizer_Zadan;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author student
 */
public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("user.pass");
        if (file.createNewFile()) {
            char[] pss0 = {'0','0','0','0'};
            LOGSystem.setPassword(pss0);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new LOGIN_PANEL().setVisible(true);
        });
    }
}
