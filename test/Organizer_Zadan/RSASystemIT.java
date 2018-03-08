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
     * Test of GenerateKeys method, of class RSASystem.
     * @throws java.security.NoSuchAlgorithmException
     */
    @Test
    public void testGenerateKeys() throws NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, NoSuchPaddingException, IOException, FileNotFoundException, IllegalBlockSizeException, ClassNotFoundException {
        System.out.println("GenerateKeys");
        Object[] Keys = RSASystem.GenerateKeys();
        String test = "String testowy";
        boolean result = test.equals(RSASystem.DECRYPTING(RSASystem.ENCRYPTING(test, (PublicKey) Keys[1]), (PrivateKey) Keys[0]));
        assert result;
        
    }

    /**
     * Test of ENCRYPTING method, of class RSASystem.
     * @throws java.security.NoSuchAlgorithmException
     * @throws java.io.IOException
     * @throws java.io.FileNotFoundException
     * @throws java.security.InvalidKeyException
     * @throws javax.crypto.NoSuchPaddingException
     * @throws javax.crypto.IllegalBlockSizeException
     * @throws javax.crypto.BadPaddingException
     */
    @Test
    public void testENCRYPTING() throws NoSuchAlgorithmException, IOException, FileNotFoundException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException{
        System.out.println("ENCRYPTING");
        String tekst = "";
        PublicKey pub = null;
        byte[] expResult = null;
        byte[] result = RSASystem.ENCRYPTING(tekst, pub);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of DECRYPTING method, of class RSASystem.
     */
    @Test
    public void testDECRYPTING() throws Exception {
        System.out.println("DECRYPTING");
        byte[] tekst = null;
        PrivateKey priv = null;
        String expResult = "";
        String result = RSASystem.DECRYPTING(tekst, priv);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
