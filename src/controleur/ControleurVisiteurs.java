/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controleur;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import modele.dao.DaoVisiteur;
import modele.dao.Jdbc;
import modele.metier.Labo;
import modele.metier.Secteur;
import modele.metier.Visiteur;
import vue.VueVisiteurs;
/**
 *
 * @author btssio
 */
public class ControleurVisiteurs extends CtrlAbstrait {
        private List<Visiteur> lesVisiteurs;
        private Visiteur unVisiteur;
        private List<Labo> lesLabos;
        private List<Secteur> lesSecteurs;

    public ControleurVisiteurs(CtrlPrincipal ctrlPrincipal){
        super(ctrlPrincipal);
        
        // préparer l'état iniitial de la vue
        try {
            Jdbc.getInstance().connecter();
            lesVisiteurs = DaoVisiteur.selectAll();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(vue, "Pilote absent");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(vue, "Echec de connexion");
        }
    }
    
    /**
     * Liste des Visiteurs
     *
     * @param lesVisiteurs : Liste de visiteurs
     */
    public void afficherListeVisiteurs(List<Visiteur> lesVisiteurs) {
        getVue().getjComboBoxSearch().removeAllItems();
        for (Visiteur lesVisiteur : lesVisiteurs) {
            getVue().getjComboBoxSearch().addItem(lesVisiteur);
        }
    }
    
    
    
        // ACCESSEURS et MUTATEURS
        @Override
    public VueVisiteurs getVue() {
        return (VueVisiteurs)vue;
    }

    public void setVue(VueVisiteurs vue) {
        this.vue = vue;
    }
    
}

