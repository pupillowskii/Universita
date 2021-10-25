
package it.unibas.mastermindSwing;

import it.unibas.mastermind.controllo.ControlloMenu;
import it.unibas.mastermind.controllo.ControlloPrincipale;
import it.unibas.mastermind.modello.Modello;
import it.unibas.mastermind.vista.Frame;
import it.unibas.mastermind.vista.VistaPrincipale;
import javax.swing.SwingUtilities;

public class Applicazione {
    private static final Applicazione singleton = new Applicazione();
    
    private Applicazione() {
    }
    
    public static Applicazione getInstance() {
        return singleton;
    }
    
    private Frame frame;
    private VistaPrincipale vistaPrincipale;
    private ControlloPrincipale controlloPrincipale;
    private ControlloMenu controlloMenu;
    private Modello modello;
    
    
    public void inizializza(){
        this.modello = new Modello();
        this.controlloPrincipale = new ControlloPrincipale();
        this.controlloMenu = new ControlloMenu();
        this.vistaPrincipale = new VistaPrincipale();
        this.frame = new Frame();
        
        this.vistaPrincipale.inizializza();
        this.frame.inizializza();
        
    }
    
     public static void main(String[] args){
         SwingUtilities.invokeLater(new Runnable(){
             @Override
             public void run() {
                 Applicazione.getInstance().inizializza();
             }
         });
         
     }

    public Frame getFrame() {
        return frame;
    }

    public VistaPrincipale getVistaPrincipale() {
        return vistaPrincipale;
    }

    public ControlloPrincipale getControlloPrincipale() {
        return controlloPrincipale;
    }

    public ControlloMenu getControlloMenu() {
        return controlloMenu;
    }

    public Modello getModello() {
        return modello;
    }
     
     
}
