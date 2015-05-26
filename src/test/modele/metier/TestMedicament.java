/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test.modele.metier;

import modele.metier.Famille;
import modele.metier.Medicament;

/**
 *
 * @author btssio
 */
public class TestMedicament {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Medicament medi=null;
        //Test n°1: instanciation et accesseurs
        System.out.println("\nTest n°1: instanciation et accesseurs");
        Famille uneFamille = new Famille("AO", "Antibiotique ophtalmique");
        medi = new Medicament("AMOX45","AMOXAR","Amoxicilline","Traite des infection bactériennes spécifiques", "Peut rendre positifs les tests de dépistage du dopage.", (float) 185.6, uneFamille);
        System.out.println("Etat du medicament: " + medi.toString());
        
        // Test n°2 : mutateurs
        System.out.println("\nTest n°2 : mutateurs");
        Famille uneFamille02 = new Famille("ANS", "Antidépresseur IMAO non sélectif");
        medi.setDepotLegal("DEPRIL9");
        medi.setNomCommercial("DEPRAMIL");
        medi.setComposition("Clomipramine");
        medi.setEffet("Médicament très efficace");
        medi.setContreIndic("Eternuements répétitifs");
        medi.setPrixEchantillon((float) 358.25);
        medi.setUneFamille(uneFamille02);
        System.out.println("Etat du medicament: " + medi.toString());
    }
    
}
