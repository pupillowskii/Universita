package it.unibas.mastermind.controllo;

import it.unibas.mastermind.modello.Combinazione;
import it.unibas.mastermind.modello.Costanti;
import it.unibas.mastermind.modello.Modello;
import it.unibas.mastermind.modello.Operatore;
import it.unibas.mastermind.modello.Partita;
import it.unibas.mastermind.modello.Risposta;
import it.unibas.mastermindSwing.Applicazione;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import static javax.swing.Action.ACCELERATOR_KEY;
import static javax.swing.Action.MNEMONIC_KEY;
import static javax.swing.Action.NAME;
import static javax.swing.Action.SHORT_DESCRIPTION;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class ControlloPrincipale {

    private Action azioneTentativo = new AzioneTentativo();

    public class AzioneTentativo extends AbstractAction {

        public AzioneTentativo() {
            this.putValue(NAME, "Tenta");
            this.putValue(SHORT_DESCRIPTION, "Tenta di indovinare la combinazione");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_T);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl T"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Modello modello = Applicazione.getInstance().getModello();
            int cifra1 = Applicazione.getInstance().getVistaPrincipale().getCifra1();
            int cifra2 = Applicazione.getInstance().getVistaPrincipale().getCifra2();
            int cifra3 = Applicazione.getInstance().getVistaPrincipale().getCifra3();
            int cifra4 = Applicazione.getInstance().getVistaPrincipale().getCifra4();
            Operatore operatore = new Operatore();
            Combinazione combinazioneTentativo = new Combinazione(cifra1, cifra2, cifra3, cifra4);
            if(operatore.verificaCorrettezza(combinazioneTentativo)){
                Partita partita = (Partita)modello.getBean(Costanti.PARTITA);
                Risposta risposta =  operatore.valutaTentativo(partita.getCombinazioneDaIndovinare(), combinazioneTentativo);
                partita.addRisposta(risposta);
                if(risposta.getPalliniNeri() == Costanti.CIFRE_COMBINAZIONE){
                    Applicazione.getInstance().getFrame().mostraMessaggio("Complimenti! \n Hai indovinato in " + partita.getNumeroTentativi() + " tentativi.", 1);
                    Applicazione.getInstance().getControlloMenu().getAzioneNuova().setEnabled(true);
                    Applicazione.getInstance().getControlloPrincipale().getAzioneTentativo().setEnabled(false);
                    Applicazione.getInstance().getControlloMenu().getAzioneInterrompi().setEnabled(false);
                    return;
                }
                Applicazione.getInstance().getFrame().mostraMessaggio(risposta.toString(), 1);
                Applicazione.getInstance().getVistaPrincipale().aggiornaTabella();
            }else{
                Applicazione.getInstance().getFrame().mostraMessaggio("Combinazione Scorretta", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    public Action getAzioneTentativo() {
        return azioneTentativo;
    }

}
