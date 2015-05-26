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
import modele.metier.Famille;
import modele.metier.Medicament;

/**
 *
 * @author btssio
 */
public class DaoMedicament {
    
    //SELECTONE -> récupération d'un médicament à partir de son identifiant
    public static Medicament selectOne(String depotLegal) throws SQLException {
        Medicament unMedicament = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM MEDICAMENT WHERE MED_DEPOTLEGAL= ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setString(1, depotLegal);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            String nomCommercial = rs.getString("MED_NOMCOMMERCIAL");
            Famille uneFamille = DaoFamille.selectOne(rs.getString("FAM_CODE"));
            String composition = rs.getString("MED_COMPOSITION");
            String effet = rs.getString("MED_EFFETS");
            String contreIndic = rs.getString("MED_CONTREINDIC");
            float prixEchantillon = rs.getFloat("MED_PRIXECHANTILLON");
            unMedicament = new Medicament(depotLegal, nomCommercial, uneFamille, composition, effet, contreIndic, prixEchantillon);
        }
        return unMedicament;
        
    }
    
    //SELECTALL -> récupération de tous les médicaments
    public static List<Medicament> selectAll() throws DaoException {
        List<Medicament> lesMedicaments = new ArrayList<Medicament>();
        Medicament unMedicament;
        ResultSet rs;
        try{
            PreparedStatement pstmt;   
            // préparer la requête
            String requete = "SELECT * FROM MEDICAMENT";
            //Connection conn=jdbc.getConnexion();
            pstmt = Jdbc.getInstance().getConnexion().prepareStatement(requete);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String depotLegal = rs.getString("MED_DEPOTLEGAL");
                String nomCommercial = rs.getString("MED_NOMCOMMERCIAL");
                Famille uneFamille = DaoFamille.selectOne(rs.getString("FAM_CODE"));
                String composition = rs.getString("MED_COMPOSITION");
                String effet = rs.getString("MED_EFFETS");
                String contreIndic = rs.getString("MED_CONTREINDIC");
                float prixEchantillon = rs.getFloat("MED_PRIXECHANTILLON");
                unMedicament = new Medicament(depotLegal, nomCommercial, uneFamille, composition, effet, contreIndic, prixEchantillon);  
                //remplissage de la liste des medicaments
                 lesMedicaments.add(unMedicament);
            }
            pstmt.close();
            rs.close();
         } catch (SQLException ex) {
            throw new DaoException("DaoMedicament - chargerUnEnregistrement : pb JDBC\n" + ex.getMessage());
        }
        return lesMedicaments;
    }
}
