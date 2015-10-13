package beans;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import classes.*;

public class beanPanier implements Serializable {

    HashMap<String, Item> map= null;
    
    public beanPanier() {
        this.map= new HashMap();
    }
    
    public void add( String ref, int qty) {
        if( map.containsKey(ref)) {
            Item i= map.get(ref);
            // i.setQty(i.getQty()+qty);
            i.delta(qty);
            if( i.getQty()<1)
               del( ref); 
        } else {
            map.put(ref, new Item(ref, qty));
        }
    }
    public void add( String ref) {
        add( ref, +1);
    }
    public void dec( String ref, int qty) {
        add( ref, -qty);
    }
    public void dec( String ref) {
        dec( ref, 1);
    }
    public void del( String ref) {
        map.remove(ref);
    }
    public void vider() {
        map.clear();
    }
    public boolean isEmpty() {
        return map.isEmpty();
    }
    public Collection<Item> liste() {
        return map.values();
    }
    public int nbItem() {
        return map.size();
    }
    public float getTotalHT() {
        return -1;
    }
    public float getTotalTTC() {
        return -1;
    }
    public void valider() {
    }
}
