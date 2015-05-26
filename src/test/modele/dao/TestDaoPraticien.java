/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test.modele.dao;

import modele.dao.DaoPraticien;
import modele.metier.Praticien;
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
public class TestDaoPraticien {
    
    public static void main(String[] args) {
        
        java.sql.Connection cnx = null;
        
        try {
            test0_Connexion();
            System.out.println("Test0 effectué : connexion\n");
            test1_SelectUnique(12);
            System.out.println("Test1 effectué : sélection unique\n");
            test2_SelectMultiple();
            System.out.println("Test2 effectué : sélection multiple\n");
            test3_SelectUniqueNom("Notini", "Alain");
            System.out.println("Test1 effectué : sélection unique\n");
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
     * Test de selection unique qui récupère un praticien en fonction de son identifiant
     * @param numPrat : identifiant du praticien
     * @throws SQLException 
     */
    public static void test1_SelectUnique(int numPrat) throws SQLException {
        Praticien cePraticien = DaoPraticien.selectOne(numPrat);
        if ( cePraticien != null) {
            System.out.println("Praticien d'identifiant : " + numPrat + " : " + cePraticien.toString02());
        } else {
            System.out.println("Le praticien d'identifiant : " +  numPrat + " n'existe pas ");
        }
        
    }

    /**
     * Test de selection multiple qui récupère tous les praticiens
     * @throws SQLException 
     */
    public static void test2_SelectMultiple() throws SQLException {
        List<Praticien> desPraticiens;
        try {
            desPraticiens = DaoPraticien.selectAll();
            System.out.println("Les praticiens lus : " + desPraticiens.toString());
        } catch (DaoException ex) {
            Logger.getLogger(TestDaoPraticien.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /**
     * Test de selection unique qui récupère un praticien en fonction de son nom et de son prénom
     * @param nomPrat
     * @param prenomPrat
     * @throws SQLException 
     */
     public static void test3_SelectUniqueNom(String nomPrat, String prenomPrat) throws SQLException {
        Praticien cePraticien = DaoPraticien.selectOneByName(nomPrat, prenomPrat);
        if ( cePraticien != null) {
            System.out.println("Praticien du nom de : " + nomPrat + " "+ prenomPrat + " : " + cePraticien.toString02());
        } else {
            System.out.println("Le praticien du nom de : " +  nomPrat + " "+ prenomPrat + " n'existe pas ");
        }
        
    }
    
}
