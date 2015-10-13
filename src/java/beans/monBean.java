package beans;

import java.beans.*;
import java.io.Serializable;
import java.util.Date;

public class monBean implements Serializable {
    
    private Date date = null;
    
    public monBean() {
        this.date= new Date();
    }

    public Date getDate() {
        return date;
    }
}
