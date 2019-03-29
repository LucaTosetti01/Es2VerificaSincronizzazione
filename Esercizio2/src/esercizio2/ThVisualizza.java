/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tosetti_luca
 */
public class ThVisualizza extends Thread{
    private CDatiCondivisi ptrDati;
    public ThVisualizza(CDatiCondivisi dati) {
        ptrDati=dati;
    }
    
    public void run() {
        try {
        while(!ptrDati.isFinito()) {
            
                ptrDati.waitThVisualizza();
                System.out.println("--------------------");
                System.out.println("telefoni suggeriti che iniziano per "+ptrDati.getSTR());
                System.out.println(ptrDati.getElenco().toString());
                System.out.println("--------------------");
                
                ptrDati.signalThInserimento();
            } 
        }catch (InterruptedException ex) {
                Logger.getLogger(ThVisualizza.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
