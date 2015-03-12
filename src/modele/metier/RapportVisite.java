/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modele.metier;


/**
 *
 * @author btssio
 */
public class RapportVisite {
    private String matricule;
    private String numRap;
    private String numPra;
    private String date;
    private String bilan;
    private String motif;
    
    private Praticien praticien;

    public RapportVisite(String matricule, String numRap, String date, String bilan, String motif, Praticien praticien) {
        this.matricule = matricule;
        this.numRap = numRap;
        this.date = date;
        this.bilan = bilan;
        this.motif = motif;
        this.praticien = praticien;
    }

    public RapportVisite(String matricule, String numRap, String numPra, String date, String bilan, String motif) {
        this.matricule = matricule;
        this.numRap = numRap;
        this.numPra = numPra;
        this.date = date;
        this.bilan = bilan;
        this.motif = motif;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNumRap() {
        return numRap;
    }

    public void setNumRap(String numRap) {
        this.numRap = numRap;
    }

    public String getNumPra() {
        return numPra;
    }

    public void setNumPra(String numPra) {
        this.numPra = numPra;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBilan() {
        return bilan;
    }

    public void setBilan(String bilan) {
        this.bilan = bilan;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }
    
    
    
    public Praticien getPraticien() {
        return praticien;
    }

    public void setPraticien(Praticien praticien) {
        this.praticien = praticien;
    }

    
    public String toString2() {
        return "RapportVisite{" + "matricule=" + matricule + ", numRap=" + numRap + ", date=" + date + ", bilan=" + bilan + ", motif=" + motif + ", praticien=" + praticien + '}';
    }
    
    public String toString(){
        return matricule;
    }
    
}
