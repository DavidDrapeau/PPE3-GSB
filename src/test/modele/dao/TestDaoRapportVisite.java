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
import modele.dao.DaoRapportVisite;
import modele.dao.Jdbc;
import modele.metier.RapportVisite;

/**
 *
 * @author btssio
 */
public class TestDaoRapportVisite {
    public static void main(String[] args) {
        
        java.sql.Connection cnx = null;
        
        try {
            test0_Connexion();
            System.out.println("Test0 effectué : connexion\n");
            test1_SelectUnique("a131");
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
        Jdbc.creer("oracle.jdbc.driver.OracleDriver", "jdbc:oracle:thin:", "@localhost:1521:XE", "", "ppegsb", "ppegsb");
        Jdbc.getInstance().connecter();
        Connection cnx = Jdbc.getInstance().getConnexion();
    }

    /**
     * Test de selection unique qui récupère un rapport de visite en fonction de son matricule
     * @param matricule : identifiant du rapport de visite
     * @throws SQLException 
     */
    public static void test1_SelectUnique(String matricule) throws SQLException {
        RapportVisite ceRapportVisite = DaoRapportVisite.selectOne(matricule);
        if ( ceRapportVisite != null) {
            System.out.println("Rapport de visite de matricule : " + matricule + " : " + ceRapportVisite.toString());
        } else {
            System.out.println("Le rapport de visite de matricule : " +  matricule + " n'existe pas ");
        }
        
    }

    /**
     * Test de selection multiple qui récupère tous les rapports de visites
     * @throws SQLException 
     */
    public static void test2_SelectMultiple() throws SQLException {
        List<RapportVisite> desRapportVisites;
        try {
            desRapportVisites = DaoRapportVisite.selectAll();
            System.out.println("Les rapports de visites lus : " + desRapportVisites.toString());
        } catch (DaoException ex) {
            Logger.getLogger(TestDaoRapportVisite.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
