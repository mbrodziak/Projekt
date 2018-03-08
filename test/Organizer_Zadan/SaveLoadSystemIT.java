/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Organizer_Zadan;

import javax.swing.table.DefaultTableModel;
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
public class SaveLoadSystemIT {
    
    public SaveLoadSystemIT() {
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
     * Test of save method, of class SaveLoadSystem.
     */
    @Test
    public void testSave() throws Exception {
        System.out.println("save");
        DefaultTableModel model = null;
        boolean AutoSave = false;
        SaveLoadSystem.save(model, AutoSave);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of load method, of class SaveLoadSystem.
     * @throws java.lang.Exception
     */
    @Test
    public void testLoad() throws Exception {
        System.out.println("load");
        DefaultTableModel model = null;
        String TYPE = "";
        boolean expResult = false;
        boolean result = SaveLoadSystem.load(model, TYPE);
        assertEquals(expResult, result);
    }
    
}
