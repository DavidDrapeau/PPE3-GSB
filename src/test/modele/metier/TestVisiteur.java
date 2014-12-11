/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test.modele.metier;

import Modele.metier.Visiteur;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author btssio
 */
public class TestVisiteur {
    public static void main(String[] args) {
        Visiteur vis=null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        //Test n°1: instanciation et accesseurs
        System.out.println("\nTest n°1: instanciation et accesseurs");
        try{
            vis = new Visiteur("b52","Poilu","Gérard","65 rue du Bourg","44000","Nantes",sdf.parse("20/11/2012"),null,"sw");
        } catch (ParseException ex) {
            Logger.getLogger(TestVisiteur.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Etat du visiteur: " + vis);
        
        // Test n°2 : mutateurs
        System.out.println("\nTest n°2 : mutateurs");
        vis.setMatricule("cb03");
        vis.setNom("Gelbro");
        vis.setPrenom("Arthur");
        vis.setAdresse("26 rue de la Liberté");
        vis.setCp("44200");
        vis.setVille("Nantes");
        vis.setCodeSecteur(null);
        vis.setCodeLabo("df");
        System.out.println("Etat du visiteur : " + vis);
    }
}
