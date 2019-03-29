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
public class ThCercaSecondaMeta extends Thread{
    private CDatiCondivisi ptrDati;
    public ThCercaSecondaMeta(CDatiCondivisi dati) {
        ptrDati=dati;
    }
    
    public void run() {
        try {
        while(!ptrDati.isFinito()) {
            
                ptrDati.waitThCercaSeconda();
                for(int i=4;i<9;i++) {
                    if(ptrDati.getElencoAgendaCell(i).startsWith(ptrDati.getSTR())) {
                        ptrDati.AggiungiAdElenco(ptrDati.getElencoAgendaCell(i));
                    }
                }
                ptrDati.signalThVisualizza();
            } 
        }catch (InterruptedException ex) {
                Logger.getLogger(ThCercaSecondaMeta.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
