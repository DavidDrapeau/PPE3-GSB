/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test.modele.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.dao.DaoException;
import modele.dao.DaoMedicament;
import modele.dao.Jdbc;
import modele.metier.Medicament;

/**
 *
 * @author btssio
 */
public class TestDaoMedicament {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.sql.Connection cnx = null;
        
        try {
            test0_Connexion();
            System.out.println("Test0 effectué : connexion\n");
            test1_SelectUnique("3MYC7");
            System.out.println("Test1 effectué : sélection unique\n");
            test2_SelectMultiple();
            System.out.println("Test2 effectué : sélection multiple\n");
        } catch (ClassNotFoundException e) {
            System.err.println("Erreur de pilote JDBC : " + e);
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e);
        } finally {
            try {
                if (cnx != null) {
                    cnx.close();
                }
            } catch (SQLException e) {
                System.err.println("Erreur de fermeture de la connexion JDBC : " + e);
            }
        }
        
    }

    /**
     * Vérifie qu'une connexion peut être ouverte sur le SGBD
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static void test0_Connexion() throws ClassNotFoundException, SQLException {
        //Jdbc.creer("oracle.jdbc.driver.OracleDriver", "jdbc:oracle:thin:", "@localhost:1521:XE", "", "ppegsb", "ppegsb");
        Jdbc.creer("oracle.jdbc.driver.OracleDriver", "jdbc:oracle:thin:", "@localhost:1521:ORCL", "", "ddrapeau", "DDRAPEAU");
        Jdbc.getInstance().connecter();
        Connection cnx = Jdbc.getInstance().getConnexion();
    }

    /**
     * Affiche un medicament d'après son identifiant
     *
     * @param depotLegal : identifiant du medicament à afficher
     * @throws SQLException
     */
    public static void test1_SelectUnique(String depotLegal) throws SQLException {
        Medicament ceMedicament = DaoMedicament.selectOne(depotLegal);
        if ( ceMedicament != null) {
            System.out.println("Medicament d'identifiant : " + depotLegal + " : " + ceMedicament.toString());
        } else {
            System.out.println("Le medicament d'identifiant : " + depotLegal + " n'existe pas ");
        }
        
    }

    /**
     * Affiche tous les medicaments
     *
     * @throws SQLException
     */
    public static void test2_SelectMultiple() throws SQLException {
        List<Medicament> desMedicaments;
        try {
            desMedicaments = DaoMedicament.selectAll();
            System.out.println("Les médicaments lus : " + desMedicaments.toString());
        } catch (DaoException ex) {
            Logger.getLogger(TestDaoVisiteur.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
