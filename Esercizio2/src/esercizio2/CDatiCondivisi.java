/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio2;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

/**
 *
 * @author tosetti_luca
 */
public class CDatiCondivisi {
    private Semaphore semThInserimento;
    private Semaphore semThCercaPrima;
    private Semaphore semThCercaSeconda;
    private Semaphore semThVisualizza;
    private Semaphore semJoin;
    private boolean finito;
    private String [] elencoAGENDA_CELL = {"02384938", "02928903","34092883903", "3339283403", "3409212345", "02300903","34192883000", "34092882012", "023928833"};
    private String STR;
    private ArrayList<String> elenco;
    
    
    public CDatiCondivisi() {
        semThInserimento=new Semaphore(1);
        semThCercaPrima=new Semaphore(0);
        semThCercaSeconda=new Semaphore(0);
        semThVisualizza=new Semaphore(0);
        semJoin=new Semaphore(0);
        
        STR="";
        elenco=new ArrayList<String>();
        finito=false;
    }

    public synchronized boolean isFinito() {
        return finito;
    }

    public synchronized void setFinito(boolean finito) {
        this.finito = finito;
    }


    public synchronized String[] getElencoAGENDA_CELL() {
        return elencoAGENDA_CELL;
    }

    public synchronized void setElencoAGENDA_CELL(String[] elencoAGENDA_CELL) {
        this.elencoAGENDA_CELL = elencoAGENDA_CELL;
    }

    public synchronized String getSTR() {
        return STR;
    }

    public synchronized void setSTR(String STR) {
        this.STR = STR;
    }

    public synchronized ArrayList<String> getElenco() {
        return elenco;
    }

    public synchronized void setElenco(ArrayList<String> elenco) {
        this.elenco = elenco;
    }
    
    public synchronized void AccodaStringa(String carattere) {
        STR=STR+carattere;
    }
    
    public synchronized String getElencoAgendaCell(int pos) {
        return elencoAGENDA_CELL[pos];
    }
    
    public synchronized void AggiungiAdElenco(String s) {
        elenco.add(s);
    }
    
    public void waitThInserimento() throws InterruptedException {
        semThInserimento.acquire();
    }
    
    public void waitThCercaPrima() throws InterruptedException {
        semThCercaPrima.acquire();
    }
    
    public void waitThCercaSeconda() throws InterruptedException {
        semThCercaSeconda.acquire();
    }
    
    public void waitThVisualizza() throws InterruptedException {
        semThVisualizza.acquire();
    }
    public void signalThInserimento() {
        semThInserimento.release();
    }
    
    public void signalThCercaPrima() {
        semThCercaPrima.release();
    }
    
    public void signalThCercaSeconda() {
        semThCercaSeconda.release();
    }
    
    public void signalThVisualizza() {
        semThVisualizza.release();
    }
    
    public void signalJoin() {
        semJoin.release();
    }
    
    public void waitJoin() throws InterruptedException {
        semJoin.acquire();
    }
}
