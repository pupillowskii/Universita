
package it.unibas.mastermind.modello;

import java.util.ArrayList;
import java.util.List;

public class Partita {
    private Combinazione combinazioneDaIndovinare;
    private List<Risposta> listaRisposte = new ArrayList<Risposta>();

    public Partita(Combinazione combinazioneDaIndovinare) {
        this.combinazioneDaIndovinare = combinazioneDaIndovinare;
    }

    public void addRisposta(Risposta risposta){
        this.listaRisposte.add(risposta);
    }

    public Combinazione getCombinazioneDaIndovinare() {
        return combinazioneDaIndovinare;
    }

    public List<Risposta> getListaRisposte() {
        return listaRisposte;
    }
    
    public int getNumeroTentativi(){
        return this.listaRisposte.size();
    }
    
    
    
    
}
