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
public class Visiteur {
    private String matricule;
    private String nom;
    private String prenom;
    private String adresse;
    private String cp;
    private String ville;
    private Date dateEmbauche;
    private String codeSecteur;
    private String codeLabo;
    
    private Secteur secteur;
    private Labo labo;

    public Visiteur(String matricule, String nom, String prenom, String adresse, String cp, String ville, Date dateEmbauche, Secteur secteur, Labo labo) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.cp = cp;
        this.ville = ville;
        this.dateEmbauche = dateEmbauche;
        this.secteur = secteur;
        this.labo = labo;
    }

    public Visiteur(String matricule, String nom, String prenom, String adresse, String cp, String ville, Date dateEmbauche, String codeSecteur, String codeLabo) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.cp = cp;
        this.ville = ville;
        this.dateEmbauche = dateEmbauche;
        this.codeSecteur = codeSecteur;
        this.codeLabo = codeLabo;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Date getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(Date dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public Secteur getSecteur() {
        return secteur;
    }

    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;
    }

    public Labo getLabo() {
        return labo;
    }

    public void setLabo(Labo labo) {
        this.labo = labo;
    }
    
    
    public String getCodeSecteur() {
        return codeSecteur;
    }

    public void setCodeSecteur(String codeSecteur1) {
        this.codeSecteur = codeSecteur1;
    }

    public String getCodeLabo() {
        return codeLabo;
    }

    public void setCodeLabo(String codeLabo1) {
        this.codeLabo = codeLabo1;
    }
    
    

    
    public String toString2() {
        return "Visiteur{" + "matricule=" + matricule + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", cp=" + cp + ", ville=" + ville + ", dateEmbauche=" + dateEmbauche + ", Secteur=" + secteur + ", Labo=" + labo + '}';
    }
    
    //Méthodde toString pour l'affichage du nom et du prénom du visiteur dans la comboBox de recherche
    public String toString() {
        return nom + " " + prenom;
    }
    
}
