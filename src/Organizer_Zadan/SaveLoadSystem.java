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
        try (PrintWriter write = new PrintWriter("user.save")) {
            for (int i = 0; i < ile; i++) {
                write.print(model.getValueAt(i, 0));
                write.print("//");
                write.print(model.getValueAt(i, 1));
                write.print("//");
                write.print(model.getValueAt(i, 2));
                write.print("//");
                if (model.getValueAt(i, 3) == null) write.println(false);
                else write.println(model.getValueAt(i, 3));
            }
            write.print("#%%#");
            write.close();
        }
    }

    public static void load(DefaultTableModel model) throws FileNotFoundException, IOException {
        BufferedReader in = new BufferedReader(new FileReader("user.save"));
        removeAll(model);
        String read = in.readLine();
        while (!read.equals("#%%#")) {
            String[] slt = read.split("//");
            boolean bool = Boolean.parseBoolean(slt[3]);
            model.addRow(new Object[]{slt[0], slt[1], slt[2], bool});
            read = in.readLine();
        }
    }

    private static void removeAll(DefaultTableModel model) {
        
    }
}
