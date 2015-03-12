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
import modele.metier.TypePraticien;

/**
 *
 * @author btssio
 */
public class DaoTypePraticien {
    //Récupérer un type de praticien d'après son id
     public static TypePraticien selectOne(String codeType) throws SQLException {
        TypePraticien unTypePraticien = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM TYPE_PRATICIEN WHERE TYP_CODE= ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setString(1, codeType);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            String libelle = rs.getString("TYP_LIBELLE");
            String lieu = rs.getString("TYP_LIEU");
            
            unTypePraticien = new TypePraticien(codeType, libelle, lieu);
        }
        return unTypePraticien;
        
    }
     
    //Récupérer tous les types de praticiens
    public static List<TypePraticien> selectAll() throws DaoException {
        List<TypePraticien> lesTypePraticiens = new ArrayList<TypePraticien>();
        TypePraticien unTypePraticien;
        ResultSet rs;
        try {
            PreparedStatement pstmt;
            Jdbc jdbc = Jdbc.getInstance();
            // préparer la requête
            String requete = "SELECT * FROM TYPE_PRATICIEN";
            pstmt = jdbc.getConnexion().prepareStatement(requete);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String codeType = rs.getString("TYP_CODE");
                String libelle = rs.getString("TYP_LIBELLE");
                String lieu = rs.getString("TYP_LIEU");
                
                unTypePraticien = new TypePraticien(codeType, libelle, lieu);
                lesTypePraticiens.add(unTypePraticien);
            }
            pstmt.close();
            rs.close();
        } catch (SQLException ex) {
            throw new DaoException("DaoPraticien - chargerUnEnregistrement : pb JDBC\n" + ex.getMessage());
        }
        return lesTypePraticiens;
    }
}
