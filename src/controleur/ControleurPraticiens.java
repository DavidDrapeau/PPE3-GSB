/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controleur;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.dao.DaoException;
import modele.dao.DaoPraticien;
import modele.metier.Praticien;
import modele.metier.TypePraticien;
import vue.VuePraticiens;

/**
 *
 * @author btssio
 */
public class ControleurPraticiens extends CtrlAbstrait{
    private List<Praticien> lesPraticiens;
    private List<TypePraticien> lesTypePraticiens;
    
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
    
    
    //ACCESSEUR ET MUTATEUR
    @Override
    public VuePraticiens getVue() {
        return vue;
    }

    public void setVue(VuePraticiens vue) {
        this.vue = vue;
    }
    
    
}
