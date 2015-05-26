/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test.modele.metier;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import modele.metier.Famille;
import modele.metier.Medicament;
import modele.metier.Offrir;
import modele.metier.Praticien;
import modele.metier.RapportVisite;
import modele.metier.TypePraticien;
import modele.metier.Visiteur;

/**
 *
 * @author btssio
 */
public class TestOffrir {

    /**
     * @param args the command line arguments
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws ParseException {
        Offrir off=null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        //Test n°1: instanciation et accesseurs
        System.out.println("\nTest n°1: instanciation et accesseurs");
        //Objet Visiteur
        Visiteur unVisiteur = new Visiteur("b52","Poilu","Gérard","65 rue du Bourg","44000","Nantes",sdf.parse("20/11/2012"),null,"sw");
        //Objet Rapport de visite
        TypePraticien unTypePra = new TypePraticien("CC", "test coucou", "local ");
        Praticien unPra = new Praticien(150, "noulet", "sylvain", "adresse", "cp", "ville", "45.2", unTypePra);
        RapportVisite unRapport = new RapportVisite("a770", sdf.parse("20/11/2012"), "Très bon médecin", "Rappot annuel", unPra);
        //Objet Medicament
        Famille uneFamille = new Famille("AO", "Antibiotique ophtalmique");
        Medicament unMedicament = new Medicament("AMOX45","AMOXAR", uneFamille,"Amoxicilline","Traite des infection bactériennes spécifiques", "Peut rendre positifs les tests de dépistage du dopage.", (float) 185.6);
        //Objet Offrir
        off = new Offrir(unVisiteur,unRapport, unMedicament,4);
        System.out.println("Etat offrir: " + off.toString());
        
        // Test n°2 : mutateurs
        System.out.println("\nTest n°2 : mutateurs");
        //Objet Visiteur
        Visiteur unVisiteur02 = new Visiteur("b63","Hugues","Jérome","65 rue du Bourg","44200","Nantes",sdf.parse("20/12/2012"),null,"sw");
        //Objet Rapport de visite
        TypePraticien unTypePra02 = new TypePraticien("CY", "test yolo", "local ");
        Praticien unPra02 = new Praticien(153, "noulet", "sylvain", "adresse", "cp", "ville", "56.2", unTypePra02);
        RapportVisite unRapport02 = new RapportVisite("a770", sdf.parse("20/11/2012"), "Très mauvais médecin", "Rappot annuel", unPra02);
        //Objet Medicament
        Famille uneFamille02 = new Famille("ANS", "Antidépresseur IMAO non sélectif");
        Medicament unMedicament02 = new Medicament("AMOX45","AMOXAR", uneFamille02,"Amoxicilline","Traite des infection bactériennes spécifiques", "Peut rendre positifs les tests de dépistage du dopage.", (float) 185.8);
        
        //Objet Offrir
        off.setUnVisiteur(unVisiteur02);
        off.setUnRapport(unRapport02);
        off.setUnMedicament(unMedicament02);
        off.setQuantite(6);
        System.out.println("Etat offrir: " + off.toString());
    }
    
}
