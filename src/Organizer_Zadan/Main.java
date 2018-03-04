/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Organizer_Zadan;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author student
 */
public class Main {

    public static void main(String[] args) throws IOException, FileNotFoundException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, ClassNotFoundException {
        File file = new File("user.save");
        char[] pss = {};
        if (file.createNewFile()) {
            char[] pss0 = {};
            LOGSystem.setPassword(pss0);
            java.awt.EventQueue.invokeLater(() -> {
                new OrganizerZadan().setVisible(true);
            });
        } else if (Arrays.equals(LOGSystem.getPassword(), pss)) {
            java.awt.EventQueue.invokeLater(() -> {
                new OrganizerZadan().setVisible(true);
            });
        } else {
            java.awt.EventQueue.invokeLater(() -> {
                new LOGIN_PANEL().setVisible(true);
            });
        }
    }
}
