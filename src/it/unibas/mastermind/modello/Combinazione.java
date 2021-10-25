package it.unibas.mastermind.modello;

public class Combinazione {

    private int[] cifre = new int[Costanti.CIFRE_COMBINAZIONE];
    
    public Combinazione(int a , int b, int c, int d){
        this.setCifraInPosizione(a, 0);
        this.setCifraInPosizione(b, 1);
        this.setCifraInPosizione(c, 2);
        this.setCifraInPosizione(d, 3);
    }
    
    public Combinazione(){
        
    }
    
    public int getCifraInPosizione(int indice) {
        if (indice < 0 || indice >= 4) {
            throw new IndexOutOfBoundsException("Sconfinamento array");
        }
        return this.cifre[indice];
    }

    public void setCifraInPosizione(int cifra,int indice) {
        if (indice < 0 || indice >= 4) {
            throw new IndexOutOfBoundsException("Sconfinamento array");
        }
        if(cifra < 1 || cifra > 6){
            throw new IllegalArgumentException("Cifra irregolare");
        }
        cifre[indice] = cifra;
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <= 3; i++){
            sb.append(this.cifre[i]).append(" ");
        }
        return sb.toString();
    }
}
