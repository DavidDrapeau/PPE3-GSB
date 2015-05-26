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

/**
 *
 * @author btssio
 */
public class DaoFamille {
    //SELECTONE -> récupération d'une famille à partir de son identifiant
    public static Famille selectOne(String code) throws SQLException {
        Famille uneFamille = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM FAMILLE WHERE FAM_CODE= ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setString(1, code);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            String libelle = rs.getString("FAM_LIBELLE");
            uneFamille = new Famille(code, libelle);
        }
        return uneFamille;
        
    }
    
    //SELECTALL -> récupération de toutes les familles
    public static List<Famille> selectAll() throws DaoException {
        List<Famille> lesFamilles = new ArrayList<Famille>();
        Famille uneFamille;
        ResultSet rs;
        try{
            PreparedStatement pstmt;   
            // préparer la requête
            String requete = "SELECT * FROM FAMILLE";
            //Connection conn=jdbc.getConnexion();
            pstmt = Jdbc.getInstance().getConnexion().prepareStatement(requete);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String code = rs.getString("FAM_CODE");
                String libelle = rs.getString("FAM_LIBELLE");
                uneFamille = new Famille(code, libelle);
                //remplissage de la liste des familles
                 lesFamilles.add(uneFamille);
            }
            pstmt.close();
            rs.close();
         } catch (SQLException ex) {
            throw new DaoException("DaoFamille - chargerUnEnregistrement : pb JDBC\n" + ex.getMessage());
        }
        return lesFamilles;
    }
}
