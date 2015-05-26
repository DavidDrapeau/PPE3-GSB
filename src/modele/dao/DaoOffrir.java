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
import modele.metier.Medicament;
import modele.metier.Offrir;
import modele.metier.RapportVisite;
import modele.metier.Visiteur;

/**
 *
 * @author btssio
 */
public class DaoOffrir {
    //SELECTONE -> récupération d'une offre à partir de son identifiant
    public static Offrir selectOne(String matriculeVisiteur, int numRapport, String depotLegalMedi) throws SQLException {
        Offrir unOffrir = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM OFFRIR WHERE VIS_MATRICULE= ? AND RAP_NUM= ? AND MED_DEPOTLEGAL= ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setString(1, matriculeVisiteur);
        pstmt.setInt(2, numRapport);
        pstmt.setString(3, depotLegalMedi);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            int quantite = rs.getInt("OFF_QTE");
            unOffrir = new Offrir(matriculeVisiteur, numRapport, depotLegalMedi, quantite);
        }
        return unOffrir;
    }
    
    //SELECTALL -> récupération de toutes les offres
    public static List<Offrir> selectAll() throws DaoException {
        List<Offrir> lesOffrirs = new ArrayList<Offrir>();
        Offrir unOffrir;
        ResultSet rs;
        try{
            PreparedStatement pstmt;   
            // préparer la requête
            String requete = "SELECT * FROM OFFRIR";
            //Connection conn=jdbc.getConnexion();
            pstmt = Jdbc.getInstance().getConnexion().prepareStatement(requete);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Visiteur unVisiteur = DaoVisiteur.selectOne(rs.getString("VIS_MATRICULE"));
                RapportVisite unRapport = DaoRapportVisite.selectOneByNum(rs.getInt("RAP_NUM"));
                Medicament unMedicament = DaoMedicament.selectOne(rs.getString("MED_DEPOTLEGAL"));
                int quantite = rs.getInt("OFF_QTE");
                unOffrir = new Offrir(unVisiteur, unRapport, unMedicament, quantite);  
                //remplissage de la liste des medicaments
                 lesOffrirs.add(unOffrir);
            }
            pstmt.close();
            rs.close();
         } catch (SQLException ex) {
            throw new DaoException("DaoOffrir - chargerUnEnregistrement : pb JDBC\n" + ex.getMessage());
        }
        return lesOffrirs;
    }
}
