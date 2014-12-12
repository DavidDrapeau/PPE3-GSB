/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controleur;

import Modele.dao.Jdbc;

/**
 *
 * @author btssio
 */
public class main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Jdbc.creer("oracle.jdbc.driver.OracleDriver", "jdbc:oracle:thin:", "@localhost:1521:XE", "GSB", "ppegsb", "ppegsb");


//        VueAuthentification uneVue = new VueAuthentification();
//        ControleurAuthentification unControleur = new ControleurAuthentification(uneVue);
//        uneVue.setControleur(unControleur);
        // afficher la vue
//        uneVue.setVisible(true);
        
    }

}
