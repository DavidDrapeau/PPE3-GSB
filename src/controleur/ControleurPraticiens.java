/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controleur;

import java.util.List;
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
    }
}
