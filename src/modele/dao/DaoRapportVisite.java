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
import modele.metier.Visiteur;

/**
 *
 * @author btssio
 */
public class DaoRapportVisite {
    private String split[] ;
    private String split2[] ;
    
    
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
     * conversion de java.util.Date vers java.sql.Date
     *
     * @param uneDate java.util.Date
     * @return java.sql.Date
     */
    public static java.sql.Date toSqlDate(java.util.Date uneDate) {
        return new java.sql.Date(uneDate.getTime());
    }

    /**
     * conversion de java.sql.Date vers java.util.Date
     *
     * @param uneDate java.sql.Date
     * @return java.util.Date
     */
    public static java.util.Date toUtilDate(java.sql.Date uneDate) {
        return new java.util.Date(uneDate.getTime());
    }
    
    
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
