/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controleur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.*;
import vue.VueAbstraite;
import vue.VueAccueil;
import vue.VueAuthentification;
/**
 *
 * @author btssio
 */
public class ControleurAuth extends CtrlAbstrait{   
    private VueAuthentification vue = new VueAuthentification(this);
    
    

    public ControleurAuth(CtrlPrincipal ctrlPrincipal ){
        super(ctrlPrincipal);
        
         //Ecouteurs Bouton ok
        vue.jAuthButtonOK.addActionListener(new ActionListener() {

            
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Coucou");
               valider();
            }
        });
        
    }
    
    public void valider(){
        String login;
        String mdp;
        
        login = vue.jAuthLogin.getText();
        mdp = vue.jAuthPass.getText();
        //Faire la verif login
        
        CtrlPrincipal CtrlP = new CtrlPrincipal();
        CtrlP.action(EnumAction.AFFICHER_MENU);
        vue.setVisible(false);
        
    }

    public VueAuthentification getVue() {
        return vue;
    }

    public void setVue(VueAuthentification vue) {
        this.vue = vue;
    }
    
    

    
    
}
