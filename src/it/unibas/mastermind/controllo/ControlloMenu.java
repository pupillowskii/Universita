package it.unibas.mastermind.controllo;

import it.unibas.mastermind.modello.Combinazione;
import it.unibas.mastermind.modello.Costanti;
import it.unibas.mastermind.modello.Modello;
import it.unibas.mastermind.modello.Operatore;
import it.unibas.mastermind.modello.Partita;
import it.unibas.mastermindSwing.Applicazione;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import static javax.swing.Action.ACCELERATOR_KEY;
import static javax.swing.Action.MNEMONIC_KEY;
import static javax.swing.Action.NAME;
import static javax.swing.Action.SHORT_DESCRIPTION;
import javax.swing.KeyStroke;

public class ControlloMenu {

    private AzioneEsci azioneEsci = new AzioneEsci();
    private AzioneNuovaPartita azioneNuova = new AzioneNuovaPartita();
    private AzioneInterrompi azioneInterrompi = new AzioneInterrompi();

    public class AzioneEsci extends AbstractAction {

        public AzioneEsci() {
            this.putValue(NAME, "Esci");
            this.putValue(SHORT_DESCRIPTION, "Esci dall'Applicazione");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_E);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl E"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    public class AzioneNuovaPartita extends AbstractAction {

        public AzioneNuovaPartita() {
            this.putValue(NAME, "Nuova Partita");
            this.putValue(SHORT_DESCRIPTION, "Fai partire una nuova partita");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_N);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl N"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Modello modello = Applicazione.getInstance().getModello();
            modello.putBean(Costanti.OPERATORE, new Operatore());
            Operatore operatore = (Operatore) modello.getBean(Costanti.OPERATORE);
            Combinazione combinazioneSegreta = operatore.genera();
            Partita partita = new Partita(combinazioneSegreta);
            modello.putBean(Costanti.PARTITA, partita);
            Applicazione.getInstance().getControlloPrincipale().getAzioneTentativo().setEnabled(true);
            Applicazione.getInstance().getControlloMenu().getAzioneNuova().setEnabled(false);
            Applicazione.getInstance().getControlloMenu().getAzioneInterrompi().setEnabled(true);
        }
    }

    public class AzioneInterrompi extends AbstractAction {

        public AzioneInterrompi() {
            this.putValue(NAME, "Interrompi Partita");
            this.putValue(SHORT_DESCRIPTION, "Interrompi e scopri la combinazione generata");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_I);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl I"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Modello modello = Applicazione.getInstance().getModello();
            Partita partita = (Partita) modello.getBean(Costanti.PARTITA);
            Applicazione.getInstance().getFrame().mostraMessaggio("Peccato :( \n " + "La combinazione da indovinare era: " + partita.getCombinazioneDaIndovinare().toString(), 1);
            Applicazione.getInstance().getControlloMenu().getAzioneNuova().setEnabled(true);
            Applicazione.getInstance().getControlloPrincipale().getAzioneTentativo().setEnabled(false);
            this.setEnabled(false);
        }

    }

    public AzioneEsci getAzioneEsci() {
        return azioneEsci;
    }

    public AzioneNuovaPartita getAzioneNuova() {
        return azioneNuova;
    }

    public AzioneInterrompi getAzioneInterrompi() {
        return azioneInterrompi;
    }

}
