package it.unibas.mastermind.modello;

import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Operatore {

    private static Random random = new Random();
    private static final Logger logger = LoggerFactory.getLogger(Operatore.class);

    public Combinazione genera() {
        Combinazione combinazione = new Combinazione();
        for (int i = 0; i <= 3; i++) {
            int numeroGenerato = random.nextInt(Costanti.CIFRA_MASSIMA) + 1;
            while (contaOccorrenze(numeroGenerato, combinazione) >= 1) {
                numeroGenerato = random.nextInt(Costanti.CIFRA_MASSIMA);
            }
            combinazione.setCifraInPosizione(numeroGenerato, i);
        }
        logger.debug("Generata la combinazione {} ", combinazione);
        return combinazione;
    }

    public int contaOccorrenze(int numeroGenerato, Combinazione combinazione) {
        int somma = 0;
        for (int i = 0; i < Costanti.CIFRE_COMBINAZIONE; i++) {
            if (combinazione.getCifraInPosizione(i) == numeroGenerato) {
                somma++;
            }
        }
        return somma;
    }

    public boolean verificaCorrettezza(Combinazione combinazione) {
        for (int i = 0; i < Costanti.CIFRE_COMBINAZIONE; i++) {
            if (contaOccorrenze(combinazione.getCifraInPosizione(i), combinazione) > 1) {
                return false;
            }
        }
        return true;
    }

    public int calcolaPalliniNeri(Combinazione combinazioneNascosta, Combinazione tentativo) {
        int palliniNeri = 0;
        for (int i = 0; i < Costanti.CIFRE_COMBINAZIONE; i++) {
            if (combinazioneNascosta.getCifraInPosizione(i) == tentativo.getCifraInPosizione(i)) {
                palliniNeri++;
                logger.debug("Trovato pallino nero in posizione: {}", i);
            }
        }
        return palliniNeri;
    }

    public int calcolaPalliniBianchi(Combinazione combinazioneNascosta, Combinazione tentativo) {
        int palliniBianchi = 0;
        for (int i = 0; i < Costanti.CIFRE_COMBINAZIONE; i++) {
            if (contaOccorrenze(tentativo.getCifraInPosizione(i), combinazioneNascosta) > 0 && tentativo.getCifraInPosizione(i) != combinazioneNascosta.getCifraInPosizione(i)) {
                palliniBianchi++;
                logger.debug("Trovato pallino bianco in posizione: {}", i);
            }
        }
        return palliniBianchi;
    }

    public Risposta valutaTentativo(Combinazione combinazioneNascosta, Combinazione tentativo) {

        logger.debug("Valuto la combinazione: {}    rispetto al tentativo: {}", combinazioneNascosta, tentativo);
        int palliniBianchi = calcolaPalliniBianchi(combinazioneNascosta, tentativo);
        int palliniNeri = calcolaPalliniNeri(combinazioneNascosta, tentativo);
        logger.debug("Pallini neri: {} - Pallini Bianchi: {} ", palliniNeri, palliniBianchi);
        return new Risposta(tentativo, palliniNeri , palliniBianchi);

    }

}
