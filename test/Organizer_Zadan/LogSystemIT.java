/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Organizer_Zadan;

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
public class LogSystemIT {
    
    public LogSystemIT() {
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
     * Test of getPassword method, of class LogSystem.
     */
    @Test
    public void testGetPassword() throws Exception {
        System.out.println("getPassword");
        char[] expResult = null;
        char[] result = LogSystem.getPassword();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class LogSystem.
     */
    @Test
    public void testSetPassword() throws Exception {
        System.out.println("setPassword");
        char[] pss0 = null;
        LogSystem.setPassword(pss0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
