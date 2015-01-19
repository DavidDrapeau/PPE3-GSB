/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test.modele.metier;

import modele.metier.TypePraticien;

/**
 *
 * @author btssio
 */
public class TestTypePraticien {
    public static void main(String[] args) {
        TypePraticien typePrat=null;
        //Test n°1: instanciation et accesseurs
        System.out.println("\nTest n°1: instanciation et accesseurs");
        typePrat = new TypePraticien("GY","Médecine de ville","Cabinet");
        System.out.println("Etat du type de praticien: " + typePrat.toString02());
        
        // Test n°2 : mutateurs
        System.out.println("\nTest n°2 : mutateurs");
        typePrat.setCodeType("MV");
        typePrat.setLibelle("Médecine de ville");
        typePrat.setLieu("Cabinet");
        System.out.println("Etat du type de praticien : " + typePrat.toString02());
    }
}
