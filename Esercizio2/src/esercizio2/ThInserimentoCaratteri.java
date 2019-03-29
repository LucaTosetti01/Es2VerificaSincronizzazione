/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio2;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tosetti_luca
 */
public class ThInserimentoCaratteri extends Thread {

    private String carattere;
    private CDatiCondivisi ptrDati;

    public ThInserimentoCaratteri(CDatiCondivisi dati) {
        ptrDati = dati;
        carattere = "";
    }

    public void run() {
        try {
            try {
                java.io.BufferedReader console = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
                while (!ptrDati.isFinito()) {

                    ptrDati.waitThInserimento();                    
                    ptrDati.getElenco().clear();

                    do {
                        System.out.print("Inserisca un nuovo carattere(non una stringa):");

                        carattere = console.readLine();
                    } while (carattere.length() > 1);

                   

                    if (carattere.equals("")) {
                        ptrDati.setFinito(true);
                    }
                    ptrDati.AccodaStringa(carattere);
                    
                    ptrDati.signalThCercaPrima();
                }
                ptrDati.signalThCercaPrima();
                ptrDati.signalThCercaSeconda();
                ptrDati.signalThVisualizza();
                ptrDati.signalJoin();
            } catch (IOException ex) {
                Logger.getLogger(ThInserimentoCaratteri.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(ThInserimentoCaratteri.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void setCarattere(String c) {
        carattere = c;
    }
}
