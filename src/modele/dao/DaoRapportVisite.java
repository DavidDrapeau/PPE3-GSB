/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modele.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modele.metier.Praticien;
import modele.metier.RapportVisite;

/**
 *
 * @author btssio
 */
public class DaoRapportVisite {
    private String split[] ;
    private String split2[] ;
    
    
    /**
     * Récupérer un rapport de visite d'après son id
     * @param matricule : identifiant du rapport de visite
     * @return
     * @throws SQLException 
     */
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
            int numRap = rs.getInt("RAP_NUM");
            Date date = rs.getDate("RAP_DATE");
            String bilan = rs.getString("RAP_BILAN");
            String motif = rs.getString("RAP_MOTIF");
            Praticien praticien = DaoPraticien.selectOne(rs.getInt("PRA_NUM"));
            
            unRapportVisite = new RapportVisite(matricule, numRap, date, bilan, motif, praticien);
        }
        return unRapportVisite;
    }
     
    /**
     * Récupérer un rapport de vsite d'après son numéro
     * @param numRap : numéro du rapport
     * @return
     * @throws SQLException 
     */
     public static RapportVisite selectOneByNum(int numRap) throws SQLException {
        RapportVisite unRapportVisite = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM RAPPORT_VISITE WHERE RAP_NUM= ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(1, numRap);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            String matricule = rs.getString("VIS_MATRICULE");
            Date date = rs.getDate("RAP_DATE");
            String bilan = rs.getString("RAP_BILAN");
            String motif = rs.getString("RAP_MOTIF");
            Praticien praticien = DaoPraticien.selectOne(rs.getInt("PRA_NUM"));
            
            unRapportVisite = new RapportVisite(matricule, numRap, date, bilan, motif, praticien);
        }
        return unRapportVisite;
    } 
     
    /**
     * Récupérer tous les rapports de visites
     * @return
     * @throws DaoException 
     */
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
                int numRap = rs.getInt("RAP_NUM");
                Date date = rs.getDate("RAP_DATE");
                String bilan = rs.getString("RAP_BILAN");
                String motif = rs.getString("RAP_MOTIF");
                Praticien praticien = DaoPraticien.selectOne(rs.getInt("PRA_NUM"));

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
    
     
    /**
     * Insertion d'un rapport de visite
     * @param unRapportVisite
     * @return
     * @throws SQLException 
     */
    public static int insert(RapportVisite unRapportVisite) throws SQLException {
        DateFormat format = new SimpleDateFormat("MM/dd/yy");
        java.sql.Date sqlDate = new java.sql.Date(unRapportVisite.getDate().getTime());
        
        String requete =" INSERT INTO RAPPORT_VISITE (VIS_MATRICULE, PRA_NUM, RAP_DATE, RAP_BILAN, RAP_MOTIF) VALUES (?,?,?,?,?)" ;
        
        PreparedStatement preparedStatement = Jdbc.getInstance().getConnexion().prepareStatement(requete);
        preparedStatement.setString(1, unRapportVisite.getMatricule());
        preparedStatement.setInt(2, unRapportVisite.getPraticien().getNumPrat());
        preparedStatement.setDate(3, sqlDate);
        preparedStatement.setString(4, unRapportVisite.getBilan());
        preparedStatement.setString(5, unRapportVisite.getMotif());
        
        
        // execute insert SQL statement
        preparedStatement.executeUpdate();
        return 1 ;
    }
}
