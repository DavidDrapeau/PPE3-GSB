/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test.modele.metier;

import modele.metier.Famille;

/**
 *
 * @author btssio
 */
public class TestFamille {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Famille fa=null;
        //Test n°1: instanciation et accesseurs
        System.out.println("\nTest n°1: instanciation et accesseurs");
        fa = new Famille("AAH","Antivertigineux antihistaminique H1");
        System.out.println("Etat de la famille: " + fa.toString());
        
        // Test n°2 : mutateurs
        System.out.println("\nTest n°2 : mutateurs");
        fa.setCode("ABC");
        fa.setLibelle("Antibiotique antiacnéique local");
        System.out.println("Etat de la famille: " + fa.toString());
    }
    
}
