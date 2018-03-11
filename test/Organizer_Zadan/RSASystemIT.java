/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Organizer_Zadan;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mateusz
 */
public class RSASystemIT {
    
    public RSASystemIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of GenerateKeys, ENCRYPTING, DECRYPTING method, of class RSASystem.
     * @throws java.security.NoSuchAlgorithmException
     * @throws javax.crypto.BadPaddingException
     */
    @Test
    public void testGenerateKeysEncryptingDecrypting() throws NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, NoSuchPaddingException, IOException, FileNotFoundException, IllegalBlockSizeException, ClassNotFoundException {
        System.out.println("GenerateKeys, Encrypting and Decrypting");
        Object[] Keys = RSASystem.GenerateKeys();
        String test = "String testowy";
        String result = RSASystem.DECRYPTING(RSASystem.ENCRYPTING(test, (PublicKey) Keys[1]), (PrivateKey) Keys[0]);
        assertEquals("Wartości nie sa rowne",test,result);
        
    }    
}
