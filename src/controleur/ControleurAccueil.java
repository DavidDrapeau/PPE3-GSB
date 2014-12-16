/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controleur;

import vue.VueAccueil;

/**
 *
 * @author btssio
 */
public class ControleurAccueil {
    
    public ControleurAccueil(){
        System.out.println("ok");
        VueAccueil vAcc = new VueAccueil(this);
        vAcc.setVisible(true);
        ////
    }
    
    public void goVisit(){

        ControleurMedicaments cMed = new ControleurMedicaments(); //
    }
    
    
    
}
