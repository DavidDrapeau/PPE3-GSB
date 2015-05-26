/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test.modele.dao;

import modele.dao.DaoVisiteur;
import modele.metier.Visiteur;
import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.dao.DaoException;
import modele.dao.Jdbc;

/**
 *
 * @author btssio
 */
public class TestDaoVisiteur {
    
    public static void main(String[] args) {
        
        java.sql.Connection cnx = null;
        
        try {
            test0_Connexion();
            System.out.println("Test0 effectué : connexion\n");
            test1_SelectUnique("a17");
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
     * Affiche un visiteur d'après son identifiant
     *
     * @param matricule : identifiant du visiteur à afficher
     * @throws SQLException
     */
    public static void test1_SelectUnique(String matricule) throws SQLException {
        Visiteur ceVisiteur = DaoVisiteur.selectOne(matricule);
        if ( ceVisiteur != null) {
            System.out.println("Visiteur d'identifiant : " + matricule + " : " + ceVisiteur.toString());
        } else {
            System.out.println("Le visiteur d'identifiant : " + matricule + " n'existe pas ");
        }
        
    }

    /**
     * Affiche tous les visiteurs
     *
     * @throws SQLException
     */
    public static void test2_SelectMultiple() throws SQLException {
        List<Visiteur> desVisiteurs;
        try {
            desVisiteurs = DaoVisiteur.selectAll();
            System.out.println("Les visiteurs lus : " + desVisiteurs.toString());
        } catch (DaoException ex) {
            Logger.getLogger(TestDaoVisiteur.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
