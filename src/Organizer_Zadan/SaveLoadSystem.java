/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Organizer_Zadan;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MatriX
 */
public class SaveLoadSystem {

    static RSA rsa;

    public static void save(DefaultTableModel model) throws NoSuchAlgorithmException, FileNotFoundException, InvalidKeyException, NoSuchPaddingException, IOException, IllegalBlockSizeException, BadPaddingException {
        rsa = new RSA();
        int ile = model.getRowCount();
        try (PrintWriter write = new PrintWriter("user.save")) {
            try (ObjectOutputStream outK = new ObjectOutputStream(new FileOutputStream("User.Key"))) {
                outK.writeObject(RSA.priv);
                outK.flush();
            }
            for (int i = 0; i < ile; i++) {
                write.print(new String((RSA.szyfruj((String) model.getValueAt(i, 0)))));
                write.print("//");
                write.print(new String((RSA.szyfruj((String) model.getValueAt(i, 1)))));
                write.print("//");
                write.print(new String((RSA.szyfruj((String) model.getValueAt(i, 2)))));
                write.print("//");
                if (model.getValueAt(i, 3) == null) {
                    write.println(false);
                } else {
                    write.println(model.getValueAt(i, 3));
                }
            }
        }
    }

    public static void load(DefaultTableModel model) throws FileNotFoundException, IOException, ClassNotFoundException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        BufferedReader in = new BufferedReader(new FileReader("user.save"));
        removeAll(model);
        ObjectInputStream inK = new ObjectInputStream(new FileInputStream("User.Key"));
        PrivateKey priv = (PrivateKey) inK.readObject();
        String read = in.readLine();
        while (!read.equals("#%%#")) {
            String[] slt = read.split("//");
            boolean bool = Boolean.parseBoolean(slt[3]);
            model.addRow(new Object[]{new String(RSA.deszyfruj(slt[0], priv)), new String(RSA.deszyfruj(slt[1], priv)), new String(RSA.deszyfruj(slt[2], priv)), bool});
            read = in.readLine();
        }
    }

    private static void removeAll(DefaultTableModel model) {
        int RC = model.getRowCount();
        for (int R = 0; R < RC; R++) {
            model.removeRow(RC);
        }
    }
}

class RSA {

    static PrivateKey priv;
    static PublicKey pub;
    static Cipher c1;

    RSA() throws NoSuchAlgorithmException {
        KeyPairGenerator kpgen = KeyPairGenerator.getInstance("RSA");
        kpgen.initialize(1024, new java.security.SecureRandom());
        KeyPair pair = kpgen.genKeyPair();
        priv = pair.getPrivate();
        pub = pair.getPublic();
    }

    static byte[] szyfruj(String tekst) throws NoSuchAlgorithmException, InvalidKeyException, FileNotFoundException, NoSuchPaddingException, IOException, IllegalBlockSizeException, BadPaddingException {
        //-- CipherStream: szyfrowanie --                                                                           
        c1 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        c1.init(Cipher.ENCRYPT_MODE, pub);
        return c1.doFinal(tekst.getBytes());
    }

    static byte[] deszyfruj(String tekst) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, FileNotFoundException, IOException, ClassNotFoundException, IllegalBlockSizeException, BadPaddingException {
        //-- CipherStream: deszyfrowanie  --                                                                        
        javax.crypto.Cipher c2 = javax.crypto.Cipher.getInstance("RSA/ECB/PKCS1Padding");
        c2.init(Cipher.DECRYPT_MODE, priv);
        return c2.doFinal(tekst.getBytes());
    }

    static byte[] deszyfruj(String tekst, PrivateKey priv) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, FileNotFoundException, IOException, ClassNotFoundException, IllegalBlockSizeException, BadPaddingException {
        //-- CipherStream: deszyfrowanie  --                                                                        
        javax.crypto.Cipher c2 = javax.crypto.Cipher.getInstance("RSA/ECB/PKCS1Padding");
        c2.init(Cipher.DECRYPT_MODE, priv);
        return c2.doFinal(tekst.getBytes());
    }
}
