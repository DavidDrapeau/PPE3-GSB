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
public class Medicament {
    private String depotLegal;
    private String nomCommercial;
    private String codeFamille;
    private String composition;
    private String effet;
    private String contreIndic;
    private float prixEchantillon;
    
    private Famille uneFamille;

    public Medicament(String depotLegal, String nomCommercial, String codeFamille, String composition, String effet, String contreIndic, float prixEchantillon) {
        this.depotLegal = depotLegal;
        this.nomCommercial = nomCommercial;
        this.codeFamille = codeFamille;
        this.composition = composition;
        this.effet = effet;
        this.contreIndic = contreIndic;
        this.prixEchantillon = prixEchantillon;
    }

    public Medicament(String depotLegal, String nomCommercial, Famille uneFamille, String composition, String effet, String contreIndic, float prixEchantillon) {
        this.depotLegal = depotLegal;
        this.nomCommercial = nomCommercial;
        this.uneFamille = uneFamille;
        this.composition = composition;
        this.effet = effet;
        this.contreIndic = contreIndic;
        this.prixEchantillon = prixEchantillon;
        
    }
    
    

    public String getDepotLegal() {
        return depotLegal;
    }

    public void setDepotLegal(String depotLegal) {
        this.depotLegal = depotLegal;
    }

    public String getNomCommercial() {
        return nomCommercial;
    }

    public void setNomCommercial(String nomCommercial) {
        this.nomCommercial = nomCommercial;
    }

    public String getCodeFamille() {
        return codeFamille;
    }

    public void setCodeFamille(String codeFamille) {
        this.codeFamille = codeFamille;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public String getEffet() {
        return effet;
    }

    public void setEffet(String effet) {
        this.effet = effet;
    }

    public String getContreIndic() {
        return contreIndic;
    }

    public void setContreIndic(String contreIndic) {
        this.contreIndic = contreIndic;
    }

    public float getPrixEchantillon() {
        return prixEchantillon;
    }

    public void setPrixEchantillon(float prixEchantillon) {
        this.prixEchantillon = prixEchantillon;
    }

    
    
    public Famille getUneFamille() {
        return uneFamille;
    }

    public void setUneFamille(Famille uneFamille) {
        this.uneFamille = uneFamille;
    }
        
    @Override 
    public String toString() {
        return "Medicament{" + "depotLegal=" + depotLegal + ", nomCommercial=" + nomCommercial + ", famille=" + uneFamille + ", composition=" + composition + ", effet=" + effet + ", contreIndic=" + contreIndic + ", prixEchantillon=" + prixEchantillon + '}';
    }
    
}
