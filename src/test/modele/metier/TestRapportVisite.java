/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test.modele.metier;

import modele.metier.RapportVisite;

/**
 *
 * @author btssio
 */
public class TestRapportVisite {
    public static void main(String[] args) {
        RapportVisite rapVi=null;
        //Test n°1: instanciation et accesseurs
        System.out.println("\nTest n°1: instanciation et accesseurs");
        rapVi = new RapportVisite("a770", "12", "4", "23/05/06", "Très bon médecin", "Rappot annuel");
        System.out.println("Etat du rapport de visite: " + rapVi.toString2());
        
        // Test n°2 : mutateurs
        System.out.println("\nTest n°2 : mutateurs");
        rapVi.setMatricule("a771");
        rapVi.setNumRap("12");
        rapVi.setNumPra("4");
        rapVi.setDate("24/05/06");
        rapVi.setBilan("Très bon médecin");
        rapVi.setMotif("Rapport hebdomadaire");
        System.out.println("Etat du rapport de visite: " + rapVi.toString2());
    }
}
