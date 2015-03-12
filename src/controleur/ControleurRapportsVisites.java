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
import modele.metier.Praticien;
import modele.metier.RapportVisite;
import vue.VueRapportsDeVisites;
import vue.VueVisiteurs;

/**
 *
 * @author btssio
 */
public class ControleurRapportsVisites extends CtrlAbstrait{
    private List<RapportVisite> lesRapportsVisites;
    private List<Praticien> lesPraticiens;
    
    VueRapportsDeVisites vue = new VueRapportsDeVisites(this);
   
    public ControleurRapportsVisites(CtrlPrincipal ctrlPrincipal) {
        super(ctrlPrincipal);
        
        //Ecouteur Bouton fermer
        vue.jButtonFermer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //System.out.println("Coucou");
                    rapportQuitter();
                } catch (Exception ex) {
                    Logger.getLogger(ControleurVisiteurs.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    
    /**
     * réaction au clic sur le bouton FERMER de la vue
     * 
     *
     * @throws java.lang.Exception
     */
    public void rapportQuitter() throws Exception {
        this.getCtrlPrincipal().action(EnumAction.RAPPORT_RETOUR);
    }
    
    // ACCESSEURS et MUTATEURS
    @Override
    public VueRapportsDeVisites getVue() {
        return (VueRapportsDeVisites)vue;
    }

    public void setVue(VueRapportsDeVisites vue) {
        this.vue = vue;
    }
}
