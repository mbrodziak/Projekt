/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Organizer_Zadan;

import java.io.FileNotFoundException;
import java.io.IOException;
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

/**
 *
 *@author Mateusz Brodziak, Mateusz Olszewski
 * 
 */
public class RSASystem {

    /**
     * 
     * @return
     * @throws NoSuchAlgorithmException 
     */
    static Object[] GenerateKeys() throws NoSuchAlgorithmException {
        KeyPairGenerator kpgen = KeyPairGenerator.getInstance("RSA");
        kpgen.initialize(1024, new java.security.SecureRandom());
        KeyPair pair = kpgen.genKeyPair();
        PrivateKey priv = pair.getPrivate();
        PublicKey pub = pair.getPublic();
        Object[] KPP = {priv, pub};
        return KPP;
    }

    /**
     * Metoda przyjmuje dwa parametry
     * @param tekst
     * @param pub
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws FileNotFoundException
     * @throws NoSuchPaddingException
     * @throws IOException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException 
     */
    static byte[] ENCRYPTING(String tekst, PublicKey pub) throws NoSuchAlgorithmException, InvalidKeyException, FileNotFoundException, NoSuchPaddingException, IOException, IllegalBlockSizeException, BadPaddingException {
        //-- CipherStream: szyfrowanie --
        Cipher c1 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        c1.init(Cipher.ENCRYPT_MODE, pub);
        return c1.doFinal(tekst.getBytes());
    }

    /**
     * Metoda przyjmuje dwa parametry
     * @param tekst
     * @param priv
     * @return
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException 
     */
    static String DECRYPTING(byte[] tekst, PrivateKey priv) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, FileNotFoundException, IOException, ClassNotFoundException, IllegalBlockSizeException, BadPaddingException {
        //-- CipherStream: deszyfrowanie  --                                                                        
        Cipher c2 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        c2.init(Cipher.DECRYPT_MODE, priv);
        return new String(c2.doFinal(tekst));
    }
}
