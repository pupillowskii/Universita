
package it.unibas.mastermind.modello;

import java.util.HashMap;
import java.util.Map;

public class Modello {
    private Map<String,Object> bean = new HashMap<String,Object>();
    
    public void putBean(String chiave, Object valore){
        this.bean.put(chiave, valore);
    }
    
    public Object getBean(String chiave){
        return this.bean.get(chiave);
    }
}
