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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modele.dao.DaoVisiteur;
import vue.VueAuthentification;
/**
 *
 * @author btssio
 */
public class ControleurAuth extends CtrlAbstrait{   
    private VueAuthentification vue = new VueAuthentification(this);
    private boolean connexion;

    public ControleurAuth(CtrlPrincipal ctrlPrincipal ){
        super(ctrlPrincipal);
        
         //Ecouteurs Bouton ok
        vue.jAuthButtonOK.addActionListener(new ActionListener() {          
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //System.out.println("Coucou");
                    valider();
                } catch (Exception ex) {
                    Logger.getLogger(ControleurAuth.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        //Ecouteur Bouton quitter
        vue.jAuthButtonQuit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //System.out.println("Coucou");
                    fichierQuitter();
                } catch (Exception ex) {
                    Logger.getLogger(ControleurAuth.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }

    /**
     *
     * Fonction qui valide ou non la connexion Selon l'id et le mot de passe
     * rentrer
     */
    public void valider() throws Exception {
        // récupération du login et mot de passe pour vérification
        String login = vue.jAuthLogin.getText();
        String mdp = vue.jAuthPass.getText();
        connexion = DaoVisiteur.verifierLoginMdp(login, mdp);
        if (connexion) {
            //System.out.print("connexion réussi");
            CtrlPrincipal ctrlP = new CtrlPrincipal();
            ctrlP.action(EnumAction.AFFICHER_MENU);
            vue.setVisible(false);
        } else {
            JFrame frame = new JFrame("JOptionPane showMessageDialog example");
            JOptionPane.showMessageDialog(frame, "Connexion invalide.");
        }
    }

    /**
     * clic sur la commande Quitter du menu Fichier Le contrôleur délègue
     * l'action au contrôleur frontal
     */
    public void fichierQuitter() throws Exception {
        this.getCtrlPrincipal().action(EnumAction.MENU_FICHIER_QUITTER);
    }
    
    
    public VueAuthentification getVue() {
        return vue;
    }

    public void setVue(VueAuthentification vue) {
        this.vue = vue;
    }
    
    

    
    
}
