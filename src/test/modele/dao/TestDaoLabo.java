/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test.modele.dao;

import modele.dao.DaoLabo;
import modele.dao.Jdbc;
import modele.metier.Labo;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.dao.DaoException;

/**
 *
 * @author btssio
 */
public class TestDaoLabo {
    
    public static void main(String[] args) throws DaoException {
        
        java.sql.Connection cnx = null;
        
        try {
            test0_Connexion();
            System.out.println("Test0 effectué : connexion\n");
            test1_SelectUnique("BC");
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
     * Affiche un visiteur d'après son identifiant
     *
     * @param codeLabo: identifiant du labo à afficher
     * @throws SQLException
     */
    public static void test1_SelectUnique(String codeLabo) throws SQLException {
        Labo ceLabo = DaoLabo.selectOne(codeLabo);
        if ( ceLabo != null) {
            System.out.println("Labo d'identifiant : " + codeLabo + " : " + ceLabo.toString());
        } else {
            System.out.println("Le labo d'identifiant : " + codeLabo + " n'existe pas ");
        }
        
    }

    /**
     * Affiche tous les labo
     *
     * @throws SQLException
     */
    public static void test2_SelectMultiple() throws SQLException {
        List<Labo> desLabos;
        try {
            desLabos = DaoLabo.selectAll();
            System.out.println("Les labo lus : " + desLabos.toString());
        } catch (DaoException ex) {
            Logger.getLogger(TestDaoLabo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
