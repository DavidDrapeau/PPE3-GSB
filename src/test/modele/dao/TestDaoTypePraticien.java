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
import modele.dao.DaoTypePraticien;
import modele.dao.Jdbc;
import modele.metier.TypePraticien;

/**
 *
 * @author btssio
 */
public class TestDaoTypePraticien {
    public static void main(String[] args) {
        
        java.sql.Connection cnx = null;
        
        try {
            test0_Connexion();
            System.out.println("Test0 effectué : connexion\n");
            test1_SelectUnique("PO");
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
        Jdbc.creer("oracle.jdbc.driver.OracleDriver", "jdbc:oracle:thin:", "@localhost:1521:XE", "", "ora_2slamppe_eq4", "equipe04");
        Jdbc.getInstance().connecter();
        Connection cnx = Jdbc.getInstance().getConnexion();
    }

    /**
     * Test de selection unique qui récupère le type d'un praticien en fonction de son identifiant
     * @param codeType
     * @throws SQLException 
     */
    public static void test1_SelectUnique(String codeType) throws SQLException {
        TypePraticien ceTypePraticien = DaoTypePraticien.selectOne(codeType);
        if ( ceTypePraticien != null) {
            System.out.println("Type de praticien d'identifiant : " + codeType + " : " + ceTypePraticien.toString02());
        } else {
            System.out.println("Le type de praticien d'identifiant : " +  codeType + " n'existe pas ");
        }
        
    }

    /**
     * Test de selection multiple qui récupère tous les types de praticien
     * @throws SQLException 
     */
    public static void test2_SelectMultiple() throws SQLException {
        List<TypePraticien> desTypePraticiens;
        try {
            desTypePraticiens = DaoTypePraticien.selectAll();
            System.out.println("Les types de praticiens lus : " + desTypePraticiens.toString());
        } catch (DaoException ex) {
            Logger.getLogger(TestDaoPraticien.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
