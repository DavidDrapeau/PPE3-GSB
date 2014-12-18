/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import vue.VueAccueil;

/**
 *
 * @author btssio
 */
public class ControleurAccueil extends CtrlAbstrait{
    VueAccueil vue = new VueAccueil(this);
    
    public ControleurAccueil(CtrlPrincipal ctrlPrincipal) {
        super(ctrlPrincipal);
        
        //Ecouteur sur le bouton Visiteur
        vue.jButtonVisi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                System.out.println("Coucou");
                afficherVisiteurs();
            }
        });
        
        //Ecouteur Bouton quitter
        vue.jButtonQuitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //System.out.println("Coucou");
                    fichierQuitter();
                } catch (Exception ex) {
                    Logger.getLogger(ControleurVisiteurs.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }
    
    public void afficherVisiteurs(){
        CtrlPrincipal CtrlP = new CtrlPrincipal();
        CtrlP.action(EnumAction.VISITEUR_AFFICHER);
        vue.setVisible(false);
    }
    
    /**
     * clic sur la commande Quitter du menu Fichier Le contrôleur délègue
     * l'action au contrôleur frontal
     */
    public void fichierQuitter() throws Exception {
        this.getCtrlPrincipal().action(EnumAction.MENU_FICHIER_QUITTER);
    }

    public VueAccueil getVue() {
        return vue;
    }

    public void setVue(VueAccueil vue) {
        this.vue = vue;
    }
    
    
    
    
    
}
