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
public class TypePraticien {
    private String codeType;
    private String libelle;
    private String lieu;

//Constructeur TypePraticien
    public TypePraticien(String codeType, String libelle, String lieu) {
        this.codeType = codeType;
        this.libelle = libelle;
        this.lieu = lieu;
    }
    
//Getters et setters   
    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }
    
    
    public String toString02() {
        return "TypePraticien{" + "codeType=" + codeType + ", libelle=" + libelle + ", lieu=" + lieu + '}';
    }
    
    @Override
    public String toString() {
        return libelle;
    }
}
