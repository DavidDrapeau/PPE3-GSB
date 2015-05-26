/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test.modele.metier;

import modele.metier.Praticien;
import modele.metier.TypePraticien;

/**
 *
 * @author btssio
 */
public class TestPraticien {
    public static void main(String[] args) {
        Praticien prat=null;
        //Test n°1: instanciation et accesseurs
        System.out.println("\nTest n°1: instanciation et accesseurs");
        TypePraticien unTypePra = new TypePraticien("CC", "test coucou", "local");
        prat = new Praticien(23,"Gaderna","Suzanne","4 rue magellan","44000", "Nantes", "124.05", unTypePra);
        System.out.println("Etat du praticien: " + prat.toString02());
        
        // Test n°2 : mutateurs
        System.out.println("\nTest n°2 : mutateurs");
        TypePraticien unTypePra02 = new TypePraticien("CY", "test yolo", "local");
        prat.setNumPrat(36);
        prat.setNomPrat("Bichana");
        prat.setPrenomPrat("Suzi");
        prat.setAdressePrat("5 rue de la vollee");
        prat.setCpPrat("44100");
        prat.setVillePrat("Saint Herblain");
        prat.setCoefNotoriete("25.6");
        prat.setTypePraticien(unTypePra02);
        System.out.println("Etat du praticien: " + prat.toString02());
    }
}
