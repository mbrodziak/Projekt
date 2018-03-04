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
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MatriX
 */
public class SaveLoadSystem {
    
static RSA rsa;

    public static void save(DefaultTableModel model, boolean AutoSave) throws NoSuchAlgorithmException, FileNotFoundException, InvalidKeyException, NoSuchPaddingException, IOException, IllegalBlockSizeException, BadPaddingException {
        rsa = new RSA();
        int ile = model.getRowCount();
        try (ObjectOutputStream outO = new ObjectOutputStream(new FileOutputStream("user.save"))) {
            outO.writeObject(rsa.priv);
            outO.writeObject(rsa.ENCRYPTING(Boolean.toString(AutoSave)));
            for (int i = 0; i < ile; i++) {
                outO.writeObject(rsa.ENCRYPTING((String) model.getValueAt(i, 0)));
                outO.writeObject(rsa.ENCRYPTING("//"));
                outO.writeObject(rsa.ENCRYPTING((String) model.getValueAt(i, 1)));
                outO.writeObject(rsa.ENCRYPTING("//"));
                outO.writeObject(rsa.ENCRYPTING((String) model.getValueAt(i, 2)));
                outO.writeObject(rsa.ENCRYPTING("//"));
                if (model.getValueAt(i, 3) == null) {
                    outO.writeObject(rsa.ENCRYPTING(Boolean.toString(false)));
                } else {
                    outO.writeObject(rsa.ENCRYPTING(Boolean.toString((boolean) model.getValueAt(i, 3))));
                }
                outO.writeObject(rsa.ENCRYPTING("%#%#"));
            }
            outO.writeObject(rsa.ENCRYPTING("#%%#"));
            outO.flush();
        }
    }

    public static boolean load(DefaultTableModel model) throws IOException, ClassNotFoundException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, FileNotFoundException, IllegalBlockSizeException, BadPaddingException {
        removeAll(model);
        boolean AutoSave;
        try (ObjectInputStream inO = new ObjectInputStream(new FileInputStream("user.save"))) {
            PrivateKey priv = (PrivateKey) inO.readObject();          
            AutoSave = Boolean.parseBoolean(RSA.DECRYPTING((byte[]) inO.readObject(), priv));
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
        return AutoSave;
    }

    private static void removeAll(DefaultTableModel model) {
        int RC = model.getRowCount();
        for (int R = RC - 1; R >= 0; R--) {
            model.removeRow(R);
        }
    }
}
