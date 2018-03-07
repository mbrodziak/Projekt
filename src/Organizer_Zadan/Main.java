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
 * Głowna klasa aplikacja
 * @author Mateusz Brodziak, Mateusz Olszewski
 * 
 */
public class Main {

    /**
     * Głowna metoda
     * Przyjmuje jeden parametr
     * Uruchamia aplikacje
     * W zależności czy jest plik save, jest ustawiane hasło
     * @param args
     * @throws IOException
     * @throws FileNotFoundException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws NoSuchPaddingException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     * @throws ClassNotFoundException 
     */
    public static void main(String[] args) throws IOException, FileNotFoundException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, ClassNotFoundException {
        File file = new File("user.save");
        char[] pss = {};
        if (file.createNewFile()) {
            char[] pss0 = {};
            LogSystem.setPassword(pss0);
            java.awt.EventQueue.invokeLater(() -> {
                new TaskOrganizer_PANEL().setVisible(true);
            });
        } else if (Arrays.equals(LogSystem.getPassword(), pss)) {
            java.awt.EventQueue.invokeLater(() -> {
                new TaskOrganizer_PANEL().setVisible(true);
            });
        } else {
            java.awt.EventQueue.invokeLater(() -> {
                new LogIn_PANEL().setVisible(true);
            });
        }
    }
}
