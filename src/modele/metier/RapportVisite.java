/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modele.metier;

import java.util.Date;


/**
 *
 * @author btssio
 */
public class RapportVisite {
    private String matricule;
    private int numRap;
    private String numPra;
    private Date date;
    private String bilan;
    private String motif;
    
    private Praticien praticien;

    public RapportVisite(String matricule, Date date, String bilan, String motif, Praticien praticien) {
        this.matricule = matricule;
        this.numRap = numRap;
        this.date = date;
        this.bilan = bilan;
        this.motif = motif;
        this.praticien = praticien;
    }

    public RapportVisite(String matricule, int numRap, String numPra, Date date, String bilan, String motif) {
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

    public int getNumRap() {
        return numRap;
    }

    public void setNumRap(int numRap) {
        this.numRap = numRap;
    }

    public String getNumPra() {
        return numPra;
    }

    public void setNumPra(String numPra) {
        this.numPra = numPra;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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

    
    public String toString() {
        return "RapportVisite{" + "matricule=" + matricule + ", date=" + date + ", bilan=" + bilan + ", motif=" + motif + ", praticien=" + praticien + '}';
    }
   
}
