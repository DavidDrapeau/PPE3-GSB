/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vue.VueAccueil;

/**
 *
 * @author btssio
 */
public class ControleurAccueil extends CtrlAbstrait{
    VueAccueil vue = new VueAccueil(this);
    
    public ControleurAccueil(CtrlPrincipal ctrlPrincipal ){
        super(ctrlPrincipal);
        
        vue.jButtonVisi.addActionListener(new ActionListener() {

            
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Coucou");
                afficherVisiteurs();
            }
        });
        
    }
    
    public void afficherVisiteurs(){
        CtrlPrincipal CtrlP = new CtrlPrincipal();
        CtrlP.action(EnumAction.VISITEUR_AFFICHER);
        vue.setVisible(false);
    }

    public VueAccueil getVue() {
        return vue;
    }

    public void setVue(VueAccueil vue) {
        this.vue = vue;
    }
    
    
    
    
    
}
