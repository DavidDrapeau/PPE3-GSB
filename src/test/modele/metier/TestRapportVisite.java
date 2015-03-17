/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test.modele.metier;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import modele.metier.Praticien;
import modele.metier.RapportVisite;
import modele.metier.TypePraticien;

/**
 *
 * @author btssio
 */
public class TestRapportVisite {
    public static void main(String[] args) throws ParseException {
        RapportVisite rapVi=null;
        //Test n°1: instanciation et accesseurs
        System.out.println("\nTest n°1: instanciation et accesseurs");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        TypePraticien unTypePra = new TypePraticien("CC", "test coucou", "local ");
        Praticien unPra = new Praticien(150, "noulet", "sylvain", "adresse", "cp", "ville", "45.2", unTypePra);
        rapVi = new RapportVisite("a770", 12, sdf.parse("20/11/2012"), "Très bon médecin", "Rappot annuel", unPra);
        System.out.println("Etat du rapport de visite: " + rapVi.toString());
        
        // Test n°2 : mutateurs
        System.out.println("\nTest n°2 : mutateurs");
        TypePraticien unTypePra02 = new TypePraticien("CY", "test yolo", "local ");
        Praticien unPra02 = new Praticien(153, "noulet", "sylvain", "adresse", "cp", "ville", "56.2", unTypePra02);
        rapVi.setMatricule("a771");
        rapVi.setNumRap(12);
        rapVi.setPraticien(unPra02);
        rapVi.setDate(sdf.parse("24/05/2006"));
        rapVi.setBilan("Très bon médecin");
        rapVi.setMotif("Rapport hebdomadaire");
        System.out.println("Etat du rapport de visite: " + rapVi.toString());
    }
}
