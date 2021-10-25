
package it.unibas.mastermind.vista;

import it.unibas.mastermindSwing.Applicazione;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Frame extends javax.swing.JFrame {
    static{
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuNuovaPartita = new javax.swing.JMenuItem();
        menuEsci = new javax.swing.JMenuItem();
        menuInterrompiPartita = new javax.swing.JMenuItem();

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("File");

        menuNuovaPartita.setText("jMenuItem1");
        jMenu1.add(menuNuovaPartita);

        menuEsci.setText("jMenuItem2");
        menuEsci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEsciActionPerformed(evt);
            }
        });
        jMenu1.add(menuEsci);

        menuInterrompiPartita.setText("jMenuItem1");
        jMenu1.add(menuInterrompiPartita);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 496, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 443, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuEsciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEsciActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuEsciActionPerformed

    public void inizializza(){
        initComponents();
        JScrollPane scroll = new JScrollPane(Applicazione.getInstance().getVistaPrincipale());
        this.setContentPane(scroll);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        inizializzaAzioni();
    }
    
    public void inizializzaAzioni(){
        this.menuEsci.setAction(Applicazione.getInstance().getControlloMenu().getAzioneEsci());
        this.menuNuovaPartita.setAction(Applicazione.getInstance().getControlloMenu().getAzioneNuova());
        this.menuInterrompiPartita.setAction(Applicazione.getInstance().getControlloMenu().getAzioneInterrompi());
    }
    
    public void mostraMessaggio(String messaggio, int categoria){
        JOptionPane.showMessageDialog(this, messaggio, "MasterMind", categoria);
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem menuEsci;
    private javax.swing.JMenuItem menuInterrompiPartita;
    private javax.swing.JMenuItem menuNuovaPartita;
    // End of variables declaration//GEN-END:variables
}
