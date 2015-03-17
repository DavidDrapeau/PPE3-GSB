/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controleur;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modele.dao.DaoException;
import modele.dao.DaoPraticien;
import modele.dao.DaoRapportVisite;
import modele.metier.Praticien;
import modele.metier.RapportVisite;
import vue.VueRapportsDeVisites;

/**
 *
 * @author btssio
 */
public class ControleurRapportsVisites extends CtrlAbstrait{
    private List<RapportVisite> lesRapportsVisites;
    private List<Praticien> lesPraticiens;
    //indice pour charger les informations d'un rapport de visite
    private int indice = 0 ;
    //Format de date de type MM/dd/yy
    DateFormat format = new SimpleDateFormat("MM/dd/yy");
    
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
                    Logger.getLogger(ControleurRapportsVisites.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        //récupère la liste des praticiens
        try {
            lesPraticiens = DaoPraticien.selectAll();
            afficherListePraticiens(lesPraticiens);
        } catch (DaoException ex) {
            Logger.getLogger(ControleurRapportsVisites.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //récupère la liste des rapports de visites
        try {
            lesRapportsVisites = DaoRapportVisite.selectAll();
            afficherDetailsRapport(lesRapportsVisites);
        } catch (DaoException ex) {
            Logger.getLogger(ControleurRapportsVisites.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Ecouteur Bouton Details concernant un praticien
        vue.jButtonDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    detailsPraticien();
                } catch (Exception ex) {
                    Logger.getLogger(ControleurRapportsVisites.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        //Ecouteur bouton précédent
        vue.jButtonPrecedent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rapportPrecedent();
            }           
        });
        //Ecouteur bouton suivant
        vue.jButtonSuivant.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rapportSuivant();
            }           
        });
        
        //Ecouteur sur bouton nouveau
        vue.jButtonNew.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nouveauRapport();
            }           
        });
        
        //Ecouteur sur bouton enregistre
        vue.jButtonEnregistrer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    enregistrerRapport();
                } catch (Exception ex) {
                    Logger.getLogger(ControleurRapportsVisites.class.getName()).log(Level.SEVERE, null, ex);
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
    
    
       /**
     * Liste des Praticiens
     *
     * @param lesPraticiens : Liste de praticiens
     */
    public void afficherListePraticiens(List<Praticien> lesPraticiens) {
        getVue().jComboBoxPraticien.removeAllItems();
        for (Praticien praticien : lesPraticiens) {  
            getVue().jComboBoxPraticien.addItem(praticien.toString());
        }
    }
    
    /**
     * Affiche les détails sur les praticiens
     */
    public void detailsPraticien(){
          getCtrlPrincipal().action(EnumAction.PRATICIEN_AFFICHER);       
    }
    
    /**
     * Afficher les informations concernant un rapport de visite sélectionné en fonction de son matricule
     * @param lesRapportsVisites 
     */
    public void afficherDetailsRapport(List<RapportVisite> lesRapportsVisites){
        //Rend les éléments non éditables
        Date date = new Date();
        getVue().jTextFieldNum.setEditable(false);
        getVue().jComboBoxPraticien.setEditable(false);
        getVue().jTextFieldDate.setText(format.format(date));
        getVue().jTextFieldDate.setEditable(false);
        getVue().jTextFieldMotif.setEditable(false);
        getVue().jTextAreaBilan.setEditable(false);
        getVue().jButtonNew.setVisible(true);
        getVue().jButtonEnregistrer.setVisible(false);
        
        //Affichage des informations sur les rapports de visites
        RapportVisite unRapport = lesRapportsVisites.get(indice);
        getVue().jTextFieldNum.setText(Integer.toString(unRapport.getNumRap()));
        getVue().jTextFieldDate.setText(format.format(unRapport.getDate()));
        getVue().jTextFieldMotif.setText(unRapport.getMotif());
        getVue().jTextAreaBilan.setText(unRapport.getBilan());
        Praticien unPraticien = unRapport.getPraticien();
        getVue().jComboBoxPraticien.setSelectedItem(unPraticien.toString());
    }
    
    /**
     * Charge le rapport de visite suivant
     */
    public void rapportSuivant(){
        indice = indice + 1;
        if (indice > lesRapportsVisites.size()-1) {
            indice = 0;
        }
        afficherDetailsRapport(lesRapportsVisites);
    }

    /**
     * Charge le rapport de visite précédent
     */
    public void rapportPrecedent(){
        indice = indice - 1;
        if (indice < 0) {
            indice = lesRapportsVisites.size()-1;
        }
        afficherDetailsRapport(lesRapportsVisites);
    }
    
    /**
     * Permet de saisir un nouveau rapport
     */
    public void nouveauRapport(){
        Date date = new Date();
        getVue().jTextFieldNum.setText(" ");
        getVue().jTextFieldNum.setEditable(false);
        getVue().jComboBoxPraticien.setEditable(true);
        getVue().jComboBoxPraticien.setSelectedItem("Aucun");
        getVue().jTextFieldDate.setText(format.format(date));
        getVue().jTextFieldDate.setText(" ");
        getVue().jTextFieldDate.setEditable(true);
        getVue().jTextFieldMotif.setText(" ") ;
        getVue().jTextFieldMotif.setEditable(true);
        getVue().jTextAreaBilan.setText(" ") ;
        getVue().jTextAreaBilan.setEditable(true);
        
        getVue().jButtonNew.setVisible(false);
        getVue().jButtonEnregistrer.setVisible(true);
    }
 
    /**
     * Insertion d'un rapport de visite 
     * @throws ParseException
     * @throws SQLException 
     */
    public void enregistrerRapport() throws ParseException, SQLException{
        String unPraticien = getVue().jComboBoxPraticien.getSelectedItem().toString() ;

        Date date = null;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String dateString = vue.jTextFieldDate.getText();
    
        try { 
            //On split le praticien(nom et prénom) afin de pouvoir récupérer son identifiant par une requête SQL 
            String split[] ;
            split = unPraticien.split(" ") ;
            String newNom = split[0] ;
            String newPrenom = split[1] ;
            Praticien lePraticienBis = DaoPraticien.selectOneByName(newNom, newPrenom) ;
            
            //Conversion de la date dans le format adéquat
            date = formatter.parse(dateString);
            
            //Récupération du motif et du bilan
            String motif = getVue().jTextFieldMotif.getText() ;
            String bilan = getVue().jTextAreaBilan.getText() ;
            
            //Création de l'objet rapport de visite
            RapportVisite unRapportVisite = new RapportVisite("zzz", date, bilan, motif, lePraticienBis);

            //Envoie du rapport de visite à la classe dao pour l'insérer dans la base de données
            DaoRapportVisite.insert(unRapportVisite) ;
            JFrame frame = new JFrame("JOptionPane showMessageDialog example");
            JOptionPane.showMessageDialog(frame, "Rapport sauvegardé");
            
            //Appel de la fonction pour afficher les rapports de visites
            afficherDetailsRapport(lesRapportsVisites);
        } catch (ParseException e) {
            JFrame frame = new JFrame("JOptionPane showMessageDialog example");
            JOptionPane.showMessageDialog(frame, "Le format de la date n'est pas valide(jj/mm/aaaa)");
        }
    }
    
   
    
    
    
    
    
    // ACCESSEURS et MUTATEURS Vue Rapports de visites
    @Override
    public VueRapportsDeVisites getVue() {
        return (VueRapportsDeVisites)vue;
    }

    public void setVue(VueRapportsDeVisites vue) {
        this.vue = vue;
    }
    
    
}
