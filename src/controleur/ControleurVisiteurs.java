/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controleur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.dao.DaoException;
import modele.dao.DaoVisiteur;
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
        
        VueVisiteurs vue = new VueVisiteurs(this);

    public ControleurVisiteurs(CtrlPrincipal ctrlPrincipal) {
        super(ctrlPrincipal);
        //récupère la liste des visiteurs 
        try {
            lesVisiteurs = DaoVisiteur.selectAll();
            afficherListeVisiteurs(lesVisiteurs);
        } catch (DaoException ex) {
            Logger.getLogger(ControleurVisiteurs.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        //Ecouteur Bouton fermer
        vue.jButtonFermer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //System.out.println("Coucou");
                    visiteurQuitter();
                } catch (Exception ex) {
                    Logger.getLogger(ControleurVisiteurs.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
    }
    
        
    
    /**
     * Liste des Visiteurs
     *
     * @param lesVisiteurs : Liste de visiteurs
     */
    public void afficherListeVisiteurs(List<Visiteur> lesVisiteurs) {
        String visiteurs = "";
        getVue().jComboBoxSearch.removeAll();
        for (Visiteur lesVisiteur : lesVisiteurs) {
            visiteurs = lesVisiteur.toString2();
            getVue().jComboBoxSearch.addItem(visiteurs);
        }
    }

    /**
     * réaction au clic sur le bouton FERMER de la vue
     * 
     *
     * @throws java.lang.Exception
     */
    public void visiteurQuitter() throws Exception {
        this.getCtrlPrincipal().action(EnumAction.VISITEUR_RETOUR);
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

