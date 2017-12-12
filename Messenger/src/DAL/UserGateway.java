/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import controller.FenetreInscriptionController;
import static java.lang.System.exit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modèle.DbConnection;
import modèle.Utilisateur;

/**
 *
 * @author ludo
 */
public class UserGateway {
    private static Connection co=DbConnection.Connect();;
    private static PreparedStatement pst;
    
    
    public static void insertUser(String nom,String prenom, String pseudo, String password, String adresse, String tele){
        if(co==null){
            System.out.println("Connexion Null");
            exit(1);
        }
        try {
            String sql="Insert into user(nom,prenom,pseudo,mdp,adresse,Tel) Values(?,?,?,?,?,?);";
        
            pst = co.prepareStatement(sql);
            pst.setString(1, nom);
            pst.setString(2, prenom);
            pst.setString(3, pseudo);
            pst.setString(4, password);
            pst.setString(5, adresse);
            pst.setString(6, tele);
            
            int i = pst.executeUpdate();
            if ( i ==1)System.out.println("Utilisateur ajouter avec succès");
            pst.close();
            
            // youtube: https://www.youtube.com/watch?v=jGJqVRTcDWI vers 30min
        } 
        catch (SQLException ex) {
            Logger.getLogger(FenetreInscriptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    public static ObservableList<Utilisateur> initializeUsers(){
        ObservableList<Utilisateur> users;
        users = FXCollections.observableArrayList();
        if(co==null){
            System.out.println("Connexion Null");
            exit(1);
        }
        
        try {
            ResultSet rs = co.createStatement().executeQuery("SELECT * FROM user");
            while (rs.next()) {
                users.add(new Utilisateur(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));                
            }
        } catch (SQLException sQLException) {
            System.out.println("Erreur chargement sql!");
        }
        return users;
        
    }
    public static Utilisateur findUserByPseudo(String pseudo){
        Utilisateur user=null;
        if(co==null){
            System.out.println("Connexion Null");
            exit(1);
        }
        try{
            System.out.println("ok");
           ResultSet userFound=co.createStatement().executeQuery("SELECT * FROM user WHERE pseudo="+pseudo);
            //String sql="SELECT * FROM USER WHERE pseudo="+pseudo+";";
            //pst = co.prepareStatement(sql);
            //pst.setString(1, pseudo);
                    
            //ResultSet userFound=pst.executeQuery();
            System.out.println("ok");
            System.out.println(userFound.getString(1));

            user = new Utilisateur(userFound.getString(1),userFound.getString(2),userFound.getString(3),userFound.getString(4),userFound.getString(5),userFound.getString(6),userFound.getString(7));
            
        }
        catch(SQLException sQLException){
            System.out.println("Erreur aucun utilisateur");
        }
            
        return user;
        
      
    }
}
