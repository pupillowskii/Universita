
package it.unibas.mastermind.vista;

import it.unibas.mastermind.modello.Combinazione;
import it.unibas.mastermind.modello.Risposta;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabella extends AbstractTableModel {
    
    private List<Risposta> listaRisposte = new ArrayList<Risposta>();
    
    public void setListaRisposte(List<Risposta> lista){
        this.listaRisposte = lista;
    }

    @Override
    public int getRowCount() {
        return this.listaRisposte.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int x) {
        if(x == 0){return "Numero tentativo";}
        if(x == 1){return "Combinazione";}
        if(x == 2){return "Pallini Neri";}
        if(x == 3){return "Pallini Bianchi";}
        return "";
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        if(columnIndex == 1){return String.class;}
        else{return Integer.class;}
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Risposta risposta = this.listaRisposte.get(rowIndex);
        if(columnIndex == 0){
            return rowIndex +1;
        }
        if(columnIndex == 1){
            return risposta.getTentativo().toString();
        }
        if(columnIndex == 2){
            return risposta.getPalliniNeri();
        }
        if(columnIndex == 3){
            return risposta.getPalliniBianchi();
        }
        return "";
    }
    
    public void aggiorna(){
        super.fireTableDataChanged();
    }
 

}
