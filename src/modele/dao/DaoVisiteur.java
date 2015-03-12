/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modele.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import modele.metier.Labo;
import modele.metier.Secteur;
import modele.metier.Visiteur;

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
        String requete = "SELECT * FROM VISITEUR WHERE VIS_MATRICULE= ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setString(1, matricule);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            String nom = rs.getString("VIS_NOM");
            String prenom = rs.getString("VIS_PRENOM");
            String adresse = rs.getString("VIS_ADRESSE");
            String cp = rs.getString("VIS_CP");
            String ville = rs.getString("VIS_VILLE");
            Date dateEmbauche = rs.getDate("VIS_DATEEMBAUCHE");
            String codeSecteur = rs.getString("SEC_CODE");
            String codeLabo = rs.getString("LAB_CODE");
            unVisiteur = new Visiteur(matricule, nom, prenom, adresse, cp, ville, dateEmbauche, codeSecteur, codeLabo);
        }
        return unVisiteur;
    }
    
    /**
     * Récupère un visiteur par son login
     * @param login
     * @return
     * @throws SQLException
     * @throws Exception 
     */
     public static Visiteur getOneByLogin(String login) throws SQLException, Exception {
        Visiteur unVisiteur = null;
        ResultSet rs = null;
        String requete = "SELECT * FROM VISITEUR WHERE VIS_NOM = ? ";
        System.out.println("Requete sans parametre : " + requete);
        PreparedStatement ps = Jdbc.getInstance().getConnexion().prepareStatement(requete);
        ps.setString(1, login);
        rs = ps.executeQuery();
        System.out.println("Requête avec paramètre : " + rs);
        if (rs.next()) {
            String matricule = rs.getString("VIS_MATRICULE");
            String nom = rs.getString("VIS_NOM");
            String prenom = rs.getString("VIS_PRENOM");
            String adresse = rs.getString("VIS_ADRESSE");
            String cp = rs.getString("VIS_CP");
            String ville = rs.getString("VIS_VILLE");
            Date dateEmbauche = rs.getDate("VIS_DATEEMBAUCHE");
            String codeSecteur = rs.getString("SEC_CODE");
            String codeLabo = rs.getString("LAB_CODE");
            unVisiteur = new Visiteur(matricule, nom, prenom, adresse, cp, ville, dateEmbauche, codeSecteur, codeLabo);
        
        }
        System.out.println("Result" + unVisiteur);
        return unVisiteur;
    }

    /**
     * Vérifier le login d'un Visiteur
     * 
     * @param login : nom du visiteur
     * @param mdp : date d'embauche avec format JJ-MMM-AA
     * @return une valeur boolean
     */
    public static boolean verifierLoginMdp(String login, String mdp) throws Exception {
        boolean ok = false;
        String dateEmbauche = null;
        Visiteur unVisiteur = getOneByLogin(login);
        System.out.println(unVisiteur.toString());
        if (unVisiteur != null) {
            Format formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            dateEmbauche = formatter.format(unVisiteur.getDateEmbauche());
        }
        System.out.println(mdp);
        System.out.println(dateEmbauche.toLowerCase());
        if (dateEmbauche != null && dateEmbauche.toLowerCase().equals(mdp)) {
            ok = true;
        }
        return ok;
    }

    
    public static List<Visiteur> selectAll() throws DaoException {
        List<Visiteur> lesVisiteurs = new ArrayList<Visiteur>();
        Visiteur unVisiteur;
        ResultSet rs;
        try{
            PreparedStatement pstmt;   
            // préparer la requête
            String requete = "SELECT * FROM VISITEUR";
            //Connection conn=jdbc.getConnexion();
            pstmt = Jdbc.getInstance().getConnexion().prepareStatement(requete);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String matricule = rs.getString("VIS_MATRICULE");
                String nom = rs.getString("VIS_NOM");
                String prenom = rs.getString("VIS_PRENOM");
                String adresse = rs.getString("VIS_ADRESSE");
                String cp = rs.getString("VIS_CP");
                String ville = rs.getString("VIS_VILLE");
                Date dateEmbauche = rs.getDate("VIS_DATEEMBAUCHE");
                Secteur secteur= DaoSecteur.selectOne(rs.getString("SEC_CODE"));
                Labo labo = DaoLabo.selectOne(rs.getString("LAB_CODE"));
                unVisiteur = new Visiteur(matricule, nom, prenom, adresse, cp, ville, dateEmbauche, secteur,labo);
                    lesVisiteurs.add(unVisiteur);
                   
            }
            pstmt.close();
            rs.close();
         } catch (SQLException ex) {
            throw new DaoException("DaoVisiteur - chargerUnEnregistrement : pb JDBC\n" + ex.getMessage());
        }
        return lesVisiteurs;
    }
    
}
