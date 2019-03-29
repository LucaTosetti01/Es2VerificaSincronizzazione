/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio2;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tosetti_luca
 */
public class Esercizio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            
            
            CDatiCondivisi dati = new CDatiCondivisi();
            
            ThInserimentoCaratteri th1 = new ThInserimentoCaratteri(dati);
            ThCercaPrimaMeta th2 = new ThCercaPrimaMeta(dati);
            ThCercaSecondaMeta th3 = new ThCercaSecondaMeta(dati);
            ThVisualizza th4 = new ThVisualizza(dati);
            
            th1.start();
            th2.start();
            th3.start();
            th4.start();
            
            
            dati.waitJoin();
            
            System.out.println("Stringa inserita:"+dati.getSTR());
            System.out.println("Contenuto elenco: "+dati.getElenco().toString());
        } catch (InterruptedException ex) {
            Logger.getLogger(Esercizio2.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }
}


