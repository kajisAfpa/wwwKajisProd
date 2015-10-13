package beans;

import java.beans.*;
import java.io.Serializable;

public class beanForm implements Serializable {

    private String nom;
    private String prenom;

    public beanForm() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPrenomNom() {
        return this.prenom + " " + this.nom;
    }

}
