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
public class Labo {
    private String codeLabo;
    private String nomLabo;
    private String chefVente;

    public Labo(String codeLabo, String nomLabo, String chefVente) {
        this.codeLabo = codeLabo;
        this.nomLabo = nomLabo;
        this.chefVente = chefVente;
    }

    public String getCodeLabo() {
        return codeLabo;
    }

    public void setCodeLabo(String codeLabo) {
        this.codeLabo = codeLabo;
    }

    public String getNomLabo() {
        return nomLabo;
    }

    public void setNomLabo(String nomLabo) {
        this.nomLabo = nomLabo;
    }

    public String getChefVente() {
        return chefVente;
    }

    public void setChefVente(String chefVente) {
        this.chefVente = chefVente;
    }


    public String toString2() {
        return "Labo{" + "codeLabo=" + codeLabo + ", nomLabo=" + nomLabo + ", chefVente=" + chefVente + '}';
    }
    
    public String toString(){
        return (nomLabo);
    }
}
