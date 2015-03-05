package controleur;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;
import modele.dao.* ;


/**
 * GSB
 * 
* @version v2 11 décembre 2014
 * @author Groupe2 Objectif : - exemple de dynamique Vue/Controleur avec
 * controleur principal - exemple de pattern Dao - exemple de singleton de
 * connexion à un SGBD - exemple de paramétrage utilisant un fichier de
 * "properties"
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        String ficPropertiesJdbc = "gsbProperties_local.properties"; // nom du fichier de properties SERVEUR LOCAL
// String ficPropertiesJdbc ="gsbJdbcLocal.properties" ; //nom du fichier de properties SERVEUR DISTANT
        Properties propertiesJdbc; // objet de propriétés (paramètres de l'appplication) pour Jdbc
        FileInputStream input; // flux de lecture des properties
        CtrlPrincipal ctrlPrincipal; // référence vers le contrôleur principal
// si au moins un paramètre a été passé sur la ligne de commandes
// le premier est le nom du fichier contenant les propriétés de connexion JDBC
        if (args.length > 0) {
            ficPropertiesJdbc = args[0];
        }
        FabriqueJdbc.creer(ficPropertiesJdbc);
        Jdbc.getInstance().connecter();
// Pour lancer l'application, instancier le contrôleur principal
        ctrlPrincipal = new CtrlPrincipal();
        ctrlPrincipal.action();
    }
}
