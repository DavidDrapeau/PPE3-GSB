/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controleur;
import java.sql.*;
import java.util.*;
import vue.VueAccueil;
import vue.VueAuthentification;
/**
 *
 * @author btssio
 */
public class ControleurAuth {
    
    
    public static void main(String args[]) {
       
        ControleurAuth cAuth = new ControleurAuth();
        cAuth.start();
        
    }
    
    public void start(){
        vAuth = new VueAuthentification(this);
        vAuth.setVisible(true);
    }
    
    public void welcome(){

        ControleurAccueil cAcc = new ControleurAccueil();
    }
    //

    public boolean connexion(String login, String pass){
        
       // String log = login;
      //  String p = pass;
        System.out.println("ok login =0" + login + "0");
        
        //code provisoir de test
        //sera replace par requête SQL login/pass)
        if("admin".equals(login)){
          
          System.out.println("true");
          welcome();
          return true;
        }else{
             System.out.println("false");
            return false;
        }
        
    }
    
    /////////////////////////////////////////////////////
    
    private VueAuthentification vAuth;
    private VueAccueil vAcc;
    
    
    
}
