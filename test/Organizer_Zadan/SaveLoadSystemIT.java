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
        DefaultTableModel model = new DefaultTableModel(0,4);
        DefaultTableModel model2 = new DefaultTableModel(0,4);
        model.addRow(new Object[]{"09-03-2018", "Myslowice", "Zadania", true});
        model.addRow(new Object[]{"10-03-2018", "Katowice", "Kino", false});
        model.addRow(new Object[]{"15-03-2018", "Chorzow", "Do tego czasu oddac indeks", false});
        boolean AutoSave = false;
        SaveLoadSystem.save(model, AutoSave);
        SaveLoadSystem.load(model2, "ALL");
        System.out.println(model2.toString());
        boolean result = model.equals(model2);
        assertEquals("Nie są równe", true,  result);
    }

    /**
     * Test of load method, of class SaveLoadSystem.
     * @throws java.lang.Exception
     */
    /*    @Test
    public void testLoad() throws Exception {
    System.out.println("load");
    DefaultTableModel model = null;
    String TYPE = "";
    boolean expResult = false;
    boolean result = SaveLoadSystem.load(model, TYPE);
    assertEquals(expResult, result);
    }*/
    
}
