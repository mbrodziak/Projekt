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
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
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
     * Test of save and load method, of class SaveLoadSystem.
     * @throws java.security.NoSuchAlgorithmException
     * @throws javax.crypto.NoSuchPaddingException
     * @throws java.security.InvalidKeyException
     * @throws java.io.IOException
     * @throws java.io.FileNotFoundException
     * @throws javax.crypto.IllegalBlockSizeException
     * @throws java.lang.ClassNotFoundException
     * @throws javax.crypto.BadPaddingException
     */
    @Test
    public void testSaveLoad() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IOException, FileNotFoundException, IllegalBlockSizeException, ClassNotFoundException, BadPaddingException {
        System.out.println("save and load");
        DefaultTableModel model = new DefaultTableModel(0,4),model2 = new DefaultTableModel(0,4);
        model.addRow(new Object[]{"09-03-2018", "Myslowice", "Zadania", true});
        model.addRow(new Object[]{"10-03-2018", "Katowice", "Kino", false});
        model.addRow(new Object[]{"15-03-2018", "Chorzow", "Do tego czasu oddac indeks", false});
        SaveLoadSystem.save(model, false);
        SaveLoadSystem.load(model2, "ALL");
        int rowCount = model.getRowCount();
        int columnCount = model.getColumnCount();
        for(int row = 0; row < rowCount; row++){
            for(int column = 0; column < columnCount; column++){
                assertEquals("Nie sa rowne", model.getValueAt(row, column), model2.getValueAt(row, column));
            }
        }    
    }
 }
