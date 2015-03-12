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
public class Praticien {
    private String numPrat;
    private String nomPrat;
    private String prenomPrat;
    private String adressePrat;
    private String cpPrat;
    private String villePrat;
    private String coefNotoriete;
    private String codeTypePraticien;
    
    private TypePraticien typePraticien;
    
  
    public Praticien(String numPrat, String nomPrat, String prenomPrat, String adressePrat, String cpPrat, String villePrat, String coefNotoriete, TypePraticien typePraticien) {
        this.numPrat = numPrat;
        this.nomPrat = nomPrat;
        this.prenomPrat = prenomPrat;
        this.adressePrat = adressePrat;
        this.cpPrat = cpPrat;
        this.villePrat = villePrat;
        this.coefNotoriete = coefNotoriete;
        this.typePraticien = typePraticien;
    }

 //Constructeur Praticien
    public Praticien(String numPrat, String nomPrat, String prenomPrat, String adressePrat, String cpPrat, String villePrat, String coefNotoriete, String codeTypePraticien) {
        this.numPrat = numPrat;
        this.nomPrat = nomPrat;
        this.prenomPrat = prenomPrat;
        this.adressePrat = adressePrat;
        this.cpPrat = cpPrat;
        this.villePrat = villePrat;
        this.coefNotoriete = coefNotoriete;
        this.codeTypePraticien = codeTypePraticien;
    }
    
  
    //Getters et setters   
    public String getNumPrat() {
        return numPrat;
    }

    public void setNumPrat(String numPrat) {
        this.numPrat = numPrat;
    }

    public String getNomPrat() {
        return nomPrat;
    }

    public void setNomPrat(String nomPrat) {
        this.nomPrat = nomPrat;
    }

    public String getPrenomPrat() {
        return prenomPrat;
    }

    public void setPrenomPrat(String prenomPrat) {
        this.prenomPrat = prenomPrat;
    }

    public String getAdressePrat() {
        return adressePrat;
    }

    public void setAdressePrat(String adressePrat) {
        this.adressePrat = adressePrat;
    }

    public String getCpPrat() {
        return cpPrat;
    }

    public void setCpPrat(String cpPrat) {
        this.cpPrat = cpPrat;
    }

    public String getVillePrat() {
        return villePrat;
    }

    public void setVillePrat(String villePrat) {
        this.villePrat = villePrat;
    }

    public String getCoefNotoriete() {
        return coefNotoriete;
    }

    public void setCoefNotoriete(String coefNotoriete) {
        this.coefNotoriete = coefNotoriete;
    }

    public String getCodeTypePraticien() {
        return codeTypePraticien;
    }

    public void setCodeTypePraticien(String typePraticien) {
        this.codeTypePraticien = typePraticien;
    }

    
    
    public TypePraticien getTypePraticien() {
        return typePraticien;
    }

    public void setTypePraticien(TypePraticien typePraticien) {
        this.typePraticien = typePraticien;
    }

    

    
    public String toString02() {
        return "Praticien{" + "numPrat=" + numPrat + ", nomPrat=" + nomPrat + ", prenomPrat=" + prenomPrat + ", adressePrat=" + adressePrat + ", cpPrat=" + cpPrat + ", villePrat=" + villePrat + ", coefNotoriete=" + coefNotoriete + ", typePraticien=" + typePraticien + '}';
    }
    
    @Override
    public String toString(){
        return nomPrat + " " +  prenomPrat;
    }
    
}
