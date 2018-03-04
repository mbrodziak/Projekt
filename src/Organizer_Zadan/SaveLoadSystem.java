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

    public static void save(DefaultTableModel model) throws NoSuchAlgorithmException, FileNotFoundException, InvalidKeyException, NoSuchPaddingException, IOException, IllegalBlockSizeException, BadPaddingException {
        int ile = model.getRowCount();
        try (ObjectOutputStream outK = new ObjectOutputStream(new FileOutputStream("User.Key"))) {
            outK.writeObject(RSA.priv);
            outK.flush();
        }
        try (ObjectOutputStream outO = new ObjectOutputStream(new FileOutputStream("user.save"))) {
            for (int i = 0; i < ile; i++) {
                outO.writeObject(RSA.ENCRYPTING((String) model.getValueAt(i, 0)));
                outO.writeObject(RSA.ENCRYPTING("//"));
                outO.writeObject(RSA.ENCRYPTING((String) model.getValueAt(i, 1)));
                outO.writeObject(RSA.ENCRYPTING("//"));
                outO.writeObject(RSA.ENCRYPTING((String) model.getValueAt(i, 2)));
                outO.writeObject(RSA.ENCRYPTING("//"));
                if (model.getValueAt(i, 3) == null) {
                    outO.writeObject(RSA.ENCRYPTING(Boolean.toString(false)));
                } else {
                    outO.writeObject(RSA.ENCRYPTING(Boolean.toString((boolean) model.getValueAt(i, 3))));
                }
                outO.writeObject(RSA.ENCRYPTING("%#%#"));
            }
            outO.writeObject(RSA.ENCRYPTING("#%%#"));
            outO.flush();
        }
    }

    public static void load(DefaultTableModel model) throws IOException, ClassNotFoundException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, FileNotFoundException, IllegalBlockSizeException, BadPaddingException {
        removeAll(model);
        PrivateKey priv;
        try (ObjectInputStream inK = new ObjectInputStream(new FileInputStream("User.Key"))) {
            priv = (PrivateKey) inK.readObject();
        }
        try (ObjectInputStream inO = new ObjectInputStream(new FileInputStream("user.save"))) {
            String read = RSA.DECRYPTING((byte[]) inO.readObject(), priv);
            while (!read.equals("#%%#")) {
                String rd = RSA.DECRYPTING((byte[]) inO.readObject(), priv);
                while (!rd.equals("%#%#")) {
                    read = read + rd;
                    rd = RSA.DECRYPTING((byte[]) inO.readObject(), priv);
                }
                String[] slt = read.split("//");
                boolean bool = Boolean.parseBoolean(slt[3]);
                model.addRow(new Object[]{slt[0], slt[1], slt[2], bool});
                read = RSA.DECRYPTING((byte[]) inO.readObject(), priv);
            }
        }
    }

    private static void removeAll(DefaultTableModel model) {
        int RC = model.getRowCount();
        for (int R = RC - 1; R >= 0; R--) {
            model.removeRow(R);
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

    static byte[] ENCRYPTING(String tekst) throws NoSuchAlgorithmException, InvalidKeyException, FileNotFoundException, NoSuchPaddingException, IOException, IllegalBlockSizeException, BadPaddingException {
        //-- CipherStream: szyfrowanie --                                                                           
        c1 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        c1.init(Cipher.ENCRYPT_MODE, pub);
        return c1.doFinal(tekst.getBytes());
    }

    static String DECRYPTING(byte[] tekst, PrivateKey priv) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, FileNotFoundException, IOException, ClassNotFoundException, IllegalBlockSizeException, BadPaddingException {
        //-- CipherStream: deszyfrowanie  --                                                                        
        Cipher c2 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        c2.init(Cipher.DECRYPT_MODE, priv);
        return new String(c2.doFinal(tekst));
    }
}
