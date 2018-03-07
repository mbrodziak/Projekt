/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Organizer_Zadan;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.table.DefaultTableModel;

/**
 *Klasa, odpowiadająca za zapisywania i wczytywanie z pliku zadań
 *@author Mateusz Brodziak, Mateusz Olszewski
 * 
 */
public class SaveLoadSystem {

    /**
     * Metoda przyjmuje dwa parametry
     * Medota, pozwalająca zapisać wprowadzone zadania z Organizatora Zadań do pliku 
     * @param model
     * @param AutoSave
     * @throws NoSuchAlgorithmException
     * @throws FileNotFoundException
     * @throws InvalidKeyException
     * @throws NoSuchPaddingException
     * @throws IOException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     * @throws ClassNotFoundException
     */
    public static void save(DefaultTableModel model, boolean AutoSave) throws NoSuchAlgorithmException, FileNotFoundException, InvalidKeyException, NoSuchPaddingException, IOException, IllegalBlockSizeException, BadPaddingException, ClassNotFoundException {
        int ile = model.getRowCount();
        Object priv;
        PublicKey pub;
        Object pss0;
        try (ObjectInputStream inO = new ObjectInputStream(new FileInputStream("user.save"))) {
            priv = inO.readObject();
            pub = (PublicKey) inO.readObject();
            pss0 = inO.readObject();
        }
        try (ObjectOutputStream outO = new ObjectOutputStream(new FileOutputStream("user.save"))) {
            outO.writeObject(priv);
            outO.writeObject(pub);
            outO.writeObject(pss0);
            outO.writeObject(RSASystem.ENCRYPTING(Boolean.toString(AutoSave), pub));
            for (int i = 0; i < ile; i++) {
                outO.writeObject(RSASystem.ENCRYPTING((String) model.getValueAt(i, 0), pub));
                outO.writeObject(RSASystem.ENCRYPTING("//", pub));
                outO.writeObject(RSASystem.ENCRYPTING((String) model.getValueAt(i, 1), pub));
                outO.writeObject(RSASystem.ENCRYPTING("//", pub));
                outO.writeObject(RSASystem.ENCRYPTING((String) model.getValueAt(i, 2), pub));
                outO.writeObject(RSASystem.ENCRYPTING("//", pub));
                if (model.getValueAt(i, 3) == null) {
                    outO.writeObject(RSASystem.ENCRYPTING(Boolean.toString(false), pub));
                } else {
                    outO.writeObject(RSASystem.ENCRYPTING(Boolean.toString((boolean) model.getValueAt(i, 3)), pub));
                }
                outO.writeObject(RSASystem.ENCRYPTING("%#%#", pub));
            }
            outO.writeObject(RSASystem.ENCRYPTING("#%%#", pub));
            outO.flush();
        }
    }

    /**
     * Metoda przyjmuje dwa parametry
     * Metoda, pozwalająca wczytać konkretne zadania z pliku do Organizatora Zadań
     * Wykorzystuje ją metoda todayLoad
     * @param model
     * @param date
     * @return true lub false, w zależności od zaznaczonej opcji Autosave
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     * @throws FileNotFoundException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     * @see todayLoad(model)

     */
    public static boolean load(DefaultTableModel model, String date) throws IOException, ClassNotFoundException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, FileNotFoundException, IllegalBlockSizeException, BadPaddingException {
        removeAll(model);
        boolean AutoSave;
        try (ObjectInputStream inO = new ObjectInputStream(new FileInputStream("user.save"))) {
            PrivateKey priv = (PrivateKey) inO.readObject();
            inO.readObject();
            inO.readObject();
            AutoSave = Boolean.parseBoolean(RSASystem.DECRYPTING((byte[]) inO.readObject(), priv));
            String read = RSASystem.DECRYPTING((byte[]) inO.readObject(), priv);
            while (!read.equals("#%%#")) {
                String rd = RSASystem.DECRYPTING((byte[]) inO.readObject(), priv);
                while (!rd.equals("%#%#")) {
                    read = read + rd;
                    rd = RSASystem.DECRYPTING((byte[]) inO.readObject(), priv);
                }
                String[] slt = read.split("//");
                boolean bool = Boolean.parseBoolean(slt[3]);
                String currentDate = slt[0];
                if (currentDate.equals(date)) {
                    model.addRow(new Object[]{date, slt[1], slt[2], bool});
                }

                read = RSASystem.DECRYPTING((byte[]) inO.readObject(), priv);
            }
        }
        return AutoSave;
    }

    /**
     * Metoda przyjmuje dwa parametry      
     * Metoda, pozwalająca wczytać wszystkie zadania z pliku do Organizatora Zadań
     * @param model
     * @return true lub false, w zależności od zaznaczonej opcji Autosave
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     * @throws FileNotFoundException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException 
     */
    public static boolean load(DefaultTableModel model) throws IOException, ClassNotFoundException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, FileNotFoundException, IllegalBlockSizeException, BadPaddingException {
        removeAll(model);
        boolean AutoSave;
        try (ObjectInputStream inO = new ObjectInputStream(new FileInputStream("user.save"))) {
            PrivateKey priv = (PrivateKey) inO.readObject();
            inO.readObject();
            inO.readObject();
            AutoSave = Boolean.parseBoolean(RSASystem.DECRYPTING((byte[]) inO.readObject(), priv));
            String read = RSASystem.DECRYPTING((byte[]) inO.readObject(), priv);
            while (!read.equals("#%%#")) {
                String rd = RSASystem.DECRYPTING((byte[]) inO.readObject(), priv);
                while (!rd.equals("%#%#")) {
                    read = read + rd;
                    rd = RSASystem.DECRYPTING((byte[]) inO.readObject(), priv);
                }
                String[] slt = read.split("//");
                boolean bool = Boolean.parseBoolean(slt[3]);

                model.addRow(new Object[]{slt[0], slt[1], slt[2], bool});

                read = RSASystem.DECRYPTING((byte[]) inO.readObject(), priv);
            }
        }
        return AutoSave;
    }

    /**
     * Metoda przyjmuje jeden parametr      
     * Metoda, pozwalająca wyświetlić zadania na dzisiaj
     * Wczytuje zadania z pliku do Organizatora zadań za pomocą metody load z dwoma parametrami
     * @param model
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     * @throws FileNotFoundException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException 
     * @see load(model, date)
     */
    public static void todayLoad(DefaultTableModel model) throws IOException, ClassNotFoundException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, FileNotFoundException, IllegalBlockSizeException, BadPaddingException {
        SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date CurrDate = new Date();
        String currentDate = dFormat.format(CurrDate);
        load(model, currentDate);
    }


    private static void removeAll(DefaultTableModel model) {
        int RC = model.getRowCount();
        for (int R = RC - 1; R >= 0; R--) {
            model.removeRow(R);
        }
    }
}
