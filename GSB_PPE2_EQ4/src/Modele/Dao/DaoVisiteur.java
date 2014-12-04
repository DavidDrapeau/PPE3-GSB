/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modele.Dao;

import Modele.metier.Visiteur;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author btssio
 */
public class DaoVisiteur {

    public static Visiteur selectOne(String matricule) throws SQLException {
        Visiteur unVisiteur = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM ADRESSE WHERE ID= ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setString(1, matricule);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            String nom = rs.getString("NOM");
            String prenom = rs.getString("PRENOM");
            String adresse = rs.getString("ADRESSE");
            String cp = rs.getString("CP");
            String ville = rs.getString("VILLE");
            Date dateEmbauche = rs.getDate("DATE_EMBAUCHE");
            String codeSecteur = rs.getString("CODE_SECTEUR");
            String codeLabo = rs.getString("CODE_LABO");
            unVisiteur = new Visiteur(matricule, nom, prenom, adresse, cp, ville, dateEmbauche, codeSecteur, codeLabo);
        }
        return unVisiteur;
    }

    public static List<Visiteur> selectAll() throws SQLException {
        List<Visiteur> lesVisiteurs = new ArrayList<Visiteur>();
        Visiteur unVisiteur;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM ADRESSE";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            String matricule = rs.getString("MATRICULE");
            String nom = rs.getString("NOM");
            String prenom = rs.getString("PRENOM");
            String adresse = rs.getString("ADRESSE");
            String cp = rs.getString("CP");
            String ville = rs.getString("VILLE");
            Date dateEmbauche = rs.getDate("DATE_EMBAUCHE");
            String codeSecteur = rs.getString("CODE_SECTEUR");
            String codeLabo = rs.getString("CODE_LABO");
            unVisiteur = new Visiteur(matricule, nom, prenom, adresse, cp, ville, dateEmbauche, codeSecteur, codeLabo);
                lesVisiteurs.add(unVisiteur);
        }
        return lesVisiteurs;
    }
    
}
