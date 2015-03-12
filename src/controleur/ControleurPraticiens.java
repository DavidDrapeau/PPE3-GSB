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
import modele.dao.DaoPraticien;
import modele.dao.DaoTypePraticien;
import modele.metier.Praticien;
import modele.metier.TypePraticien;
import vue.VuePraticiens;

/**
 *
 * @author btssio
 */
public class ControleurPraticiens extends CtrlAbstrait{
    private List<Praticien> lesPraticiens;
    private List<TypePraticien> lesTypesPraticiens;
    
    VuePraticiens vue = new VuePraticiens(this);

    public ControleurPraticiens(CtrlPrincipal ctrlPrincipal) {
        super(ctrlPrincipal);
        
        //récupère la liste des praticiens
        try {
            lesPraticiens = DaoPraticien.selectAll();
            afficherListePraticiens(lesPraticiens);
        } catch (DaoException ex) {
            Logger.getLogger(ControleurVisiteurs.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Ecouteur Bouton fermer
        vue.jButtonClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //System.out.println("Coucou");
                    praticienQuitter();
                } catch (Exception ex) {
                    Logger.getLogger(ControleurVisiteurs.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        //Ecouteur Bouton ok pour afficher les info d'un praticien
        vue.jButtonOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    praticienSelectionne();
                } catch (Exception ex) {
                    Logger.getLogger(ControleurVisiteurs.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        //Ecouteur bouton précédent
        vue.jButtonPrec.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                praticienPrecedent();
            }           
        });
        //Ecouteur bouton suivant
        vue.jButtonSuiv.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                praticienSuivant();
            }           
        });
        
        
        //récupère la liste des types de praticiens
        try{
            lesTypesPraticiens = DaoTypePraticien.selectAll();
            afficherListeTypesPraticiens(lesTypesPraticiens);
        }catch (DaoException ex) {
            Logger.getLogger(ControleurPraticiens.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    /**
     * Liste des Praticiens
     *
     * @param lesPraticiens : Liste de praticiens
     */
    public void afficherListePraticiens(List<Praticien> lesPraticiens) {
        getVue().jComboBoxSearch.removeAllItems();
        for (Praticien praticien : lesPraticiens) {  
            getVue().jComboBoxSearch.addItem(praticien);
        }
    }
    
    /**
     * Liste des Types de Praticiens
     *
     * @param lesTypesPraticiens : Liste de Types de praticiens
     */
    public void afficherListeTypesPraticiens(List<TypePraticien> lesTypesPraticiens) {
        getVue().jComboBoxLieu.removeAllItems();
        vue.jComboBoxLieu.addItem("aucun");
        for (TypePraticien typePraticien : lesTypesPraticiens) {           
            getVue().jComboBoxLieu.addItem(typePraticien.getLieu());
        }
    }
    
     /**
     * réaction au clic sur le bouton FERMER de la vue
     * 
     *
     * @throws java.lang.Exception
     */
    public void praticienQuitter() throws Exception {
        this.getCtrlPrincipal().action(EnumAction.PRATICIEN_RETOUR);
    }
    
    /**
     * Affiche les détails du praticien courant selectionné dans la comboBox recherche
     *
     */
    public void praticienSelectionne(){
        Praticien praticienSelect = (Praticien) getVue().jComboBoxSearch.getSelectedItem();
        System.out.println(praticienSelect.toString02());
        
        getVue().jTextFieldNum.setText(praticienSelect.getNumPrat());
        getVue().jTextFieldNom.setText(praticienSelect.getNomPrat());
        getVue().jTextFieldPrenom.setText(praticienSelect.getPrenomPrat());
        getVue().jTextFieldAdresse.setText(praticienSelect.getAdressePrat());
        getVue().jTextFieldVille.setText(praticienSelect.getVillePrat());
        getVue().jTextFieldCp.setText(praticienSelect.getCpPrat());
        getVue().jTextFieldCoefNotoriete.setText(praticienSelect.getCoefNotoriete());
        
        TypePraticien typePraticien = praticienSelect.getTypePraticien();
        System.out.println("TypePraticien:\n" + typePraticien);
        if (typePraticien != null) {
            vue.jComboBoxLieu.setSelectedItem(typePraticien.getLieu());
        } else {
            vue.jComboBoxLieu.setSelectedItem("aucun");
        }
    }
    
     /**Bouton suivant. affiche le praticien suivant
    *
    */
    public void praticienSuivant(){
        int index = getVue().jComboBoxSearch.getSelectedIndex() + 1;
        if (index == getVue().jComboBoxSearch.getItemCount()) {
            index = 0;
        }
        getVue().jComboBoxSearch.setSelectedIndex(index);
        praticienSelectionne();
    }
    
    
    /**
    Bouton précédent, affiche le praticien précédent
    */
    public void praticienPrecedent(){
        int index = getVue().jComboBoxSearch.getSelectedIndex() - 1;
        if (index == -1) {
            index = getVue().jComboBoxSearch.getItemCount() - 1;
        }
        getVue().jComboBoxSearch.setSelectedIndex(index);
        praticienSelectionne();
    }
    
    
    //ACCESSEUR ET MUTATEUR
    @Override
    public VuePraticiens getVue() {
        return vue;
    }

    public void setVue(VuePraticiens vue) {
        this.vue = vue;
    }
    
    
}
