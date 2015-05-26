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
public class Offrir {
    private String matriculeVisiteur;
    private int numRapport;
    private String depotLegalMedi;
    private int quantite;
    
    private Visiteur unVisiteur;
    private RapportVisite unRapport;
    private Medicament unMedicament;

    public Offrir(String matriculeVisiteur, int numRapport, String depotLegalMedi, int quantite) {
        this.matriculeVisiteur = matriculeVisiteur;
        this.numRapport = numRapport;
        this.depotLegalMedi = depotLegalMedi;
        this.quantite = quantite;
    }

    public Offrir(Visiteur unVisiteur, RapportVisite unRapport, Medicament unMedicament, int quantite) {
        this.quantite = quantite;
        this.unVisiteur = unVisiteur;
        this.unRapport = unRapport;
        this.unMedicament = unMedicament;
    }
    
    

    public String getMatriculeVisiteur() {
        return matriculeVisiteur;
    }

    public void setMatriculeVisiteur(String matriculeVisiteur) {
        this.matriculeVisiteur = matriculeVisiteur;
    }

    public int getNumRapport() {
        return numRapport;
    }

    public void setNumRapport(int numRapport) {
        this.numRapport = numRapport;
    }

    public String getDepotLegalMedi() {
        return depotLegalMedi;
    }

    public void setDepotLegalMedi(String depotLegalMedi) {
        this.depotLegalMedi = depotLegalMedi;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    
    //Getters and Setters - Objets Visiteur, Rapport de visite et Medicament
    public Visiteur getUnVisiteur() {
        return unVisiteur;
    }

    public void setUnVisiteur(Visiteur unVisiteur) {
        this.unVisiteur = unVisiteur;
    }

    public RapportVisite getUnRapport() {
        return unRapport;
    }

    public void setUnRapport(RapportVisite unRapport) {
        this.unRapport = unRapport;
    }

    public Medicament getUnMedicament() {
        return unMedicament;
    }

    public void setUnMedicament(Medicament unMedicament) {
        this.unMedicament = unMedicament;
    }

    @Override
    public String toString() {
        return "Offrir{" + "unVisiteur=" + unVisiteur + ", unRapport=" + unRapport + ", unMedicament=" + unMedicament + ", quantite=" + quantite +'}';
    }
    
    public String toString02() {
        return "Offrir{" + "matriculeVisiteur=" + matriculeVisiteur + ", numRapport=" + numRapport + ", depotLegalMedi=" + depotLegalMedi + ", quantite=" + quantite +'}';
    }

    
}
