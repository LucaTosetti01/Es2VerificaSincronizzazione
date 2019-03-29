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
public class ThCercaPrimaMeta extends Thread{
    private CDatiCondivisi ptrDati;
    public ThCercaPrimaMeta(CDatiCondivisi dati) {
        ptrDati=dati;
    }
    
    public void run() {
        try {
        while(!ptrDati.isFinito()) {
            
                ptrDati.waitThCercaPrima();
                for(int i=0;i<4;i++) {
                    if(ptrDati.getElencoAgendaCell(i).startsWith(ptrDati.getSTR())) {
                        ptrDati.AggiungiAdElenco(ptrDati.getElencoAgendaCell(i));
                    }
                }
                ptrDati.signalThCercaSeconda();
            }
        } catch (InterruptedException ex) {
                Logger.getLogger(ThCercaPrimaMeta.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
