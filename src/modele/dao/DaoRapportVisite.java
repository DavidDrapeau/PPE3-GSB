/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modele.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modele.metier.Praticien;
import modele.metier.RapportVisite;

/**
 *
 * @author btssio
 */
public class DaoRapportVisite {
    //Récupérer un rapport de visite d'après son id
     public static RapportVisite selectOne(String matricule) throws SQLException {
        RapportVisite unRapportVisite = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM RAPPORT_VISITE WHERE VIS_MATRICULE= ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setString(1, matricule);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            String numRap = rs.getString("RAP_NUM");
            String numPra = rs.getString("PRA_NUM");
            String date = rs.getString("RAP_DATE");
            String bilan = rs.getString("RAP_BILAN");
            String motif = rs.getString("RAP_MOTIF");
            
            unRapportVisite = new RapportVisite(matricule, numRap, numPra, date, bilan, motif);
        }
        return unRapportVisite;
    }
     
    //Récupérer tous les rapports de visite
    public static List<RapportVisite> selectAll() throws DaoException {
        List<RapportVisite> lesRapportVisites = new ArrayList<RapportVisite>();
        RapportVisite unRapportVisite;
        ResultSet rs;
        try {
            PreparedStatement pstmt;
            Jdbc jdbc = Jdbc.getInstance();
            // préparer la requête
            String requete = "SELECT * FROM RAPPORT_VISITE";
            pstmt = jdbc.getConnexion().prepareStatement(requete);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String matricule = rs.getString("VIS_MATRICULE");
                String numRap = rs.getString("RAP_NUM");
                String date = rs.getString("RAP_DATE");
                String bilan = rs.getString("RAP_BILAN");
                String motif = rs.getString("RAP_MOTIF");
                Praticien praticien = DaoPraticien.selectOne(rs.getString("PRA_NUM"));

                unRapportVisite = new RapportVisite(matricule, numRap, date, bilan, motif, praticien);
                lesRapportVisites.add(unRapportVisite);
            }
            pstmt.close();
            rs.close();
        } catch (SQLException ex) {
            throw new DaoException("DaoRapportVisite - chargerUnEnregistrement : pb JDBC\n" + ex.getMessage());
        }
        return lesRapportVisites;
    }
}
