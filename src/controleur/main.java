/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.sql.Connection;
import java.sql.SQLException;
import modele.dao.Jdbc;
import vue.*;

/**
 *
 * @author btssio
 */
public class main {

    public static void main(String args[]) {

        CtrlPrincipal ctrlPrincipal; // référence vers le contrôleur principal
        
        java.sql.Connection cnx = null;
        
        try{
            Jdbc.creer("oracle.jdbc.driver.OracleDriver", "jdbc:oracle:thin:", "@localhost:1521:XE", "", "ora_2slamppe_eq4", "ora_2sla");
            Jdbc.getInstance().connecter();
            cnx = Jdbc.getInstance().getConnexion();
        } catch (ClassNotFoundException e) {
            System.err.println("Erreur de pilote JDBC : " + e);
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e);
        }

        // Pour lancer l'application, instancier le contrôleur principal
        ctrlPrincipal = new CtrlPrincipal();
        ctrlPrincipal.action();

    }

}
