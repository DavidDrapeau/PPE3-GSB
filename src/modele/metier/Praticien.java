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
    private int numPrat;
    private String nomPrat;
    private String prenomPrat;
    private String adressePrat;
    private String cpPrat;
    private String villePrat;
    private float coefNotoriete;
    private String codeType;

 //Constructeur Praticien
    public Praticien(int numPrat, String nomPrat, String prenomPrat, String adressePrat, String cpPrat, String villePrat, float coefNotoriete, String codeType) {
        this.numPrat = numPrat;
        this.nomPrat = nomPrat;
        this.prenomPrat = prenomPrat;
        this.adressePrat = adressePrat;
        this.cpPrat = cpPrat;
        this.villePrat = villePrat;
        this.coefNotoriete = coefNotoriete;
        this.codeType = codeType;
    }

 //Getters et setters   
    public int getNumPrat() {
        return numPrat;
    }

    public void setNumPrat(int numPrat) {
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

    public float getCoefNotoriete() {
        return coefNotoriete;
    }

    public void setCoefNotoriete(float coefNotoriete) {
        this.coefNotoriete = coefNotoriete;
    }

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    
    public String toString02() {
        return "Praticien{" + "numPrat=" + numPrat + ", nomPrat=" + nomPrat + ", prenomPrat=" + prenomPrat + ", adressePrat=" + adressePrat + ", cpPrat=" + cpPrat + ", villePrat=" + villePrat + ", coefNotoriete=" + coefNotoriete + ", codeType=" + codeType + '}';
    }
    
    @Override
    public String toString(){
        return nomPrat + " " +  prenomPrat;
    }
    
}
