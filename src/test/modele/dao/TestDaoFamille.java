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
import modele.dao.DaoFamille;
import modele.dao.Jdbc;
import modele.metier.Famille;

/**
 *
 * @author btssio
 */
public class TestDaoFamille {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.sql.Connection cnx = null;

        try {
            test0_Connexion();
            System.out.println("Test0 effectué : connexion\n");
            test1_SelectUnique("HYP");
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
        //Jdbc.creer("oracle.jdbc.driver.OracleDriver", "jdbc:oracle:thin:", "@localhost:1521:ORCL", "", "ddrapeau", "DDRAPEAU");
        Jdbc.getInstance().connecter();
        Connection cnx = Jdbc.getInstance().getConnexion();
    }

    /**
     * Affiche une famille d'après son identifiant
     *
     * @param code : identifiant d'une famille à afficher
     * @throws SQLException
     */
    public static void test1_SelectUnique(String code) throws SQLException {
        Famille cetteFamille = DaoFamille.selectOne(code);
        if (cetteFamille != null) {
            System.out.println("Famille d'identifiant : " + code + " : " + cetteFamille.toString());
        } else {
            System.out.println("La famille d'identifiant : " + code + " n'existe pas ");
        }

    }

    /**
     * Affiche toutes les familles
     *
     * @throws SQLException
     */
    public static void test2_SelectMultiple() throws SQLException {
        List<Famille> desFamilles;
        try {
            desFamilles = DaoFamille.selectAll();
            System.out.println("Les familles lues : " + desFamilles.toString());
        } catch (DaoException ex) {
            Logger.getLogger(TestDaoVisiteur.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

