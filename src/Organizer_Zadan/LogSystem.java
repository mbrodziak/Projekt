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
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * 
 */
public class LogSystem {

    static char [] getPassword() throws FileNotFoundException, IOException, ClassNotFoundException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
        char[] pss0;
        try (ObjectInputStream inP = new ObjectInputStream(new FileInputStream("user.save"))) {
            PrivateKey priv = (PrivateKey) inP.readObject();
            inP.readObject();
            pss0 = RSASystem.DECRYPTING((byte[]) inP.readObject(), priv).toCharArray();
        }
        return pss0;
            
    }

    static void setPassword(char[] pss0) throws FileNotFoundException, IOException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        try (ObjectOutputStream outP = new ObjectOutputStream(new FileOutputStream("user.save"))) {
            Object[] KPP = RSASystem.GenerateKeys();
            outP.writeObject(KPP[0]);
            outP.writeObject(KPP[1]);
            outP.writeObject(RSASystem.ENCRYPTING(new String (pss0), (PublicKey) KPP[1]));
            outP.flush();
        }
    }
}
