/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controleur;

import vue.VueAbstraite;
import vue.VueAccueil;
import vue.VueAuthentification;
import vue.VueVisiteurs;

/**
 *
 * @author btssio
 */
public class CtrlPrincipal {
    
    private ControleurAuth ControleurAuth = null;
    private ControleurAccueil ControleurAccueil = null;
    private ControleurVisiteurs ControleurVisiteurs = null;
    VueAbstraite vueA = null;
    CtrlAbstrait ctrlA = null;
    VueAuthentification vueC = new VueAuthentification(ctrlA);

    /**
     * action par défaut action au démarrage de l'application
     */
    public void action() {
        if (ControleurAuth == null) {
            ControleurAuth = new ControleurAuth(this);
        }
        ControleurAuth.getVue().setEnabled(true);
        ControleurAuth.getVue().setVisible(true);
    }

    public void action(EnumAction action) {
        switch (action) {
            case AFFICHER_MENU: // activation de vueMenu depuis vueConnexion
                afficherMenu();
                break;
            case VISITEUR_AFFICHER: // activation de vueVisiteurs depuis vueMenu
                afficherVisiteurs();
                break;
            case MENU_FICHIER_QUITTER: // fin de l'application depuis vueMenu
                menuFichierQuitter();
                break;
        }

    }

    /**
     * Fin définitive de l'application La demande de confirmation est gérée par
     * le contrôleur spécialisé
     */
    private void menuFichierQuitter() {
        System.exit(0);
    }
    
    
    /**
     * Transition vueMenu / vuePresence
     */
    private void afficherMenu() {
        if (ControleurAuth == null) {
            ControleurAuth = new ControleurAuth(this);
        }
        VueAccueil vueM = new VueAccueil(ctrlA);
        ControleurAccueil = new ControleurAccueil(this);
        // vuPresence est une fenêtre modale :
        // -> vueMenu reste visible, mais n'est pas active
        ControleurAuth.getVue().setEnabled(false);
        ControleurAuth.getVue().setVisible(false);
        ControleurAccueil.getVue().setVisible(true);
    }
    
    private void afficherVisiteurs(){
        if (ControleurAccueil == null) {
            VueAccueil vueM = new VueAccueil(ctrlA);
            ControleurAccueil = new ControleurAccueil(this);
        }
        if (ControleurVisiteurs == null) {
            VueVisiteurs vueV = new VueVisiteurs(ctrlA);
            ControleurVisiteurs = new ControleurVisiteurs(this);
        } else {
            // si la le contrôleur et sa vue existent déjà
            // il faut rafraîchir le contenu à partir de la base de données
           // ControleurVisiteurs.afficherVisteur();
        }
        // vuPresence est une fenêtre modale :
        // -> vueMenu reste visible, mais n'est pas active
        ControleurAccueil.getVue().setEnabled(false);
        ControleurAccueil.getVue().setVisible(false);
        ControleurVisiteurs.getVue().setVisible(true);
    }
    
}
