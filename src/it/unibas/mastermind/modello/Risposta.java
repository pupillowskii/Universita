
package it.unibas.mastermind.modello;

public class Risposta {
    
    private Combinazione tentativo;
    private int palliniNeri;
    private int palliniBianchi;

    public Risposta(Combinazione tentativo, int palliniNeri, int palliniBianchi) {
        this.tentativo = tentativo;
        this.palliniNeri = palliniNeri;
        this.palliniBianchi = palliniBianchi;
    }

    public Combinazione getTentativo() {
        return tentativo;
    }

    public int getPalliniNeri() {
        return palliniNeri;
    }

    public int getPalliniBianchi() {
        return palliniBianchi;
    }
 
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Tentativo: ").append(tentativo).append("\n");
        sb.append("Numero pallini neri: ").append(palliniNeri).append("\n");
        sb.append("Numero pallini bianchi: ").append(palliniBianchi).append("\n");
        return sb.toString();
    }
    
    
    
    
}
