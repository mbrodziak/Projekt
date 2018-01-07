/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Organizer_Zadan;

/**
 *
 * @author Mateusz
 */
public class Zadania {
    String zadanie;
    
    
    public Zadania(String zadanie){
        this.zadanie = zadanie;
        
    }
    
    void dodajZadanie(String zad){
        zadanie = zad;
    
    }
}
