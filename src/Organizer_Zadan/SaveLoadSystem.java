/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Organizer_Zadan;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MatriX
 */
public class SaveLoadSystem {

    public static void save(DefaultTableModel model) throws FileNotFoundException {
        int ile = model.getRowCount();
        try (PrintWriter zapis = new PrintWriter("user.save")) {
            for (int i = 0; i < ile; i++) {
                zapis.print(model.getValueAt(i, 0));
                zapis.print(", ");
                zapis.print(model.getValueAt(i, 1));
                zapis.print(", ");
                zapis.print(model.getValueAt(i, 2));
                zapis.print(", ");
                if (model.getValueAt(i, 3) == null) {
                    model.setValueAt(false, i, 3);
                }
                zapis.println(model.getValueAt(i, 3));
            }
            zapis.print("#");
            zapis.close();
        }
    }

    public static void load(DefaultTableModel model) throws FileNotFoundException, IOException {
        BufferedReader in = new BufferedReader(new FileReader("user.save"));
        String czyt = in.readLine();
        System.out.println(czyt);
        while (!czyt.equals("#")) {
            String[] podzial = czyt.split(", ");
            boolean bool = Boolean.parseBoolean(podzial[3]);
            model.addRow(new Object[]{podzial[0], podzial[1], podzial[2], bool});
            System.out.println(podzial[0]);
            System.out.println(podzial[1]);
            System.out.println(podzial[2]);
            System.out.println(podzial[3]);
            czyt = in.readLine();
            System.out.println(czyt);
        }
    }
}
