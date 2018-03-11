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
import java.util.Arrays;
import org.junit.Assert;

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
     * Test of setPassword and getPassowrd method, of class LogSystem.
     * @throws java.lang.Exception
     */
    @Test
    public void testSetGetPassword() throws Exception {
        System.out.println("setPassword and getPassword");
        char[] pass = {'#', '$', '%', '^', '^', '&', '&', '*'};
        LogSystem.setPassword(pass);
        char[] passw = LogSystem.getPassword();
        assertArrayEquals("Hasla nie sa takie same", pass, passw);        
    }
 }
