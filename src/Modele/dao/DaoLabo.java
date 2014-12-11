/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modele.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Modele.metier.Labo;

/**
 *
 * @author btssio
 */
public class DaoLabo {
    public static Labo selectOne(String codeLabo) throws SQLException {
        Labo unLabo = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM LABO WHERE ID= ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setString(1, codeLabo);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            String nomLabo = rs.getString("LAB_NOM");
            String chefVente = rs.getString("LAB_CHEFVENTE");
            unLabo = new Labo(codeLabo, nomLabo, chefVente);
        }
        return unLabo;
    }

    public static List<Labo> selectAll() throws SQLException {
        List<Labo> lesLabos = new ArrayList<Labo>();
        Labo unLabo;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM LABO";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            String codeLabo = rs.getString("LAB_CODE");
            String nomLabo = rs.getString("LAB_NOM");
            String chefVente = rs.getString("LAB_CHEFVENTE");
            unLabo = new Labo(codeLabo, nomLabo, chefVente);
            lesLabos.add(unLabo);
        }
        return lesLabos;
    }
}
