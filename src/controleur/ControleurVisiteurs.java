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
import modele.dao.DaoLabo;
import modele.dao.DaoSecteur;
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
        //récupère la liste des labo
        try {
            lesLabos = DaoLabo.selectAll();
            afficherListeLabo(lesLabos);
        } catch (DaoException ex) {
            Logger.getLogger(ControleurVisiteurs.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Récupère la liste des secteurs
        try {
            lesSecteurs = DaoSecteur.selectAll();
            afficherListeSecteur(lesSecteurs);
        } catch (DaoException ex) {
            Logger.getLogger(ControleurVisiteurs.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Ecouteur Bouton ok pour afficher les info d'une personne
        vue.jButtonOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    visiteurSelectionne();
                } catch (Exception ex) {
                    Logger.getLogger(ControleurVisiteurs.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        //Ecouteur bouton précédent
        vue.jButtonPrecedent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                visiteurPrecedent();
            }           
        });
        //Ecouteur bouton suivant
        vue.jButtonSuivant.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                visiteurSuivant();
            }           
        });
    }
    
        
    
    /**
     * Liste des Visiteurs
     *
     * @param lesVisiteurs : Liste de visiteurs
     */
    public void afficherListeVisiteurs(List<Visiteur> lesVisiteurs) {
        getVue().jComboBoxSearch.removeAll();
        for (Visiteur visiteur : lesVisiteurs) {           
            getVue().jComboBoxSearch.addItem(visiteur);
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
    
    /**
     *
     * Charger la liste des labo relatifs à la base de donnée
     *
     * @throws DaoException
     * @throws Exception
     */
    private void afficherListeLabo(List<Labo> lesLabos){
        getVue().jComboBoxLabo.removeAll();
        vue.jComboBoxLabo.addItem("aucun");
        for (Labo labo : lesLabos) {
            getVue().jComboBoxLabo.addItem(labo);
        }
    }

    /**
     *
     *
     * Charge la liste des Secteurs relatifs à la base de donnée
     *
     * @throws DaoException
     */

    private void afficherListeSecteur(List<Secteur> lesSecteurs) throws DaoException {
        getVue().jComboBoxSecteur.removeAll();
        vue.jComboBoxSecteur.addItem("aucun");
        for (Secteur secteur : lesSecteurs) {
            getVue().jComboBoxSecteur.addItem(secteur);
        }
    }
    
    
        /**
     * Affiche les détails du visiteur courant selectionnée dans la comboBox recherche
     *
     */
    public void visiteurSelectionne (){
        Visiteur visiteurSelect = (Visiteur) getVue().jComboBoxSearch.getSelectedItem();
        System.out.println(visiteurSelect.toString2());
        
        getVue().jTextFieldNom.setText(visiteurSelect.getNom());
        getVue().jTextFieldPrenom.setText(visiteurSelect.getPrenom());
        getVue().jTextFieldAdresse.setText(visiteurSelect.getAdresse());
        getVue().jTextFieldVille.setText(visiteurSelect.getVille());
        getVue().jTextFieldVilleNumCp.setText(visiteurSelect.getCp());
        
         
        Secteur secteur = visiteurSelect.getSecteur();
        System.out.println(secteur);
        if(secteur != null)
        {
             getVue().jComboBoxSecteur.setSelectedItem(secteur.getLibelleSec());
        } else 
        {
            getVue().jComboBoxSecteur.setSelectedItem("aucun");
        }
       
        Labo labo = visiteurSelect.getLabo();
        System.out.println(labo);
        if(labo != null)
        {
            getVue().jComboBoxLabo.setSelectedItem(labo.getNomLabo());
        } else 
        {
             getVue().jComboBoxLabo.setSelectedItem("aucun");
        } 
        
    }
    
    /**Bouton suivant. affiche le visiteur suivant
    *
    */
    public void visiteurSuivant(){
        int index = getVue().jComboBoxSearch.getSelectedIndex() + 1;
        if (index == getVue().jComboBoxSearch.getItemCount()) {
            index = 0;
        }
        getVue().jComboBoxSearch.setSelectedIndex(index);
        visiteurSelectionne();
    }
    /**
    Bouton précédent, affiche le visiteur précédent
    */
    public void visiteurPrecedent(){
        int index = getVue().jComboBoxSearch.getSelectedIndex() - 1;
        if (index == -1) {
            index = getVue().jComboBoxSearch.getItemCount() - 1;
        }
        getVue().jComboBoxSearch.setSelectedIndex(index);
        visiteurSelectionne();
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

