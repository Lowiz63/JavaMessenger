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
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modèle.DbConnection;
import modèle.Etat;
import modèle.Utilisateur;

/**
 *
 * @author ludo
 */
public class UserGateway {
    private static Connection co=DbConnection.Connect();;
    private static PreparedStatement pst;
    private static ResultSet rs;
    private static ObservableList<Utilisateur> users;
    private static String sql;
    
    
    public static Utilisateur insertUser(String nom,String prenom, String pseudo, String password, String adresse, String tele, int port){
        if(co==null){
            System.out.println("Connexion Null");
            exit(1);
        }
        try {
            sql="Insert into user(nom,prenom,pseudo,mdp,adresse,Tel) Values(?,?,?,?,?,?,?);";
        
            pst = co.prepareStatement(sql);
            pst.setString(1, nom);
            pst.setString(2, prenom);
            pst.setString(3, pseudo);
            pst.setString(4, password);
            pst.setString(5, adresse);
            pst.setString(6, tele);
            pst.setInt(8, port);
            
            int i = pst.executeUpdate();
            if ( i ==1)System.out.println("Utilisateur ajouter avec succès");
            pst.close();
            return new Utilisateur(nom,prenom,pseudo,password,adresse,tele, port);
            
            // youtube: https://www.youtube.com/watch?v=jGJqVRTcDWI vers 30min
        } 
        catch (SQLException ex) {
            Logger.getLogger(FenetreInscriptionController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
            
    }
    public static ObservableList<Utilisateur> initializeUsers(){
        users = FXCollections.observableArrayList();
        if(co==null){
            System.out.println("Connexion Null");
            exit(1);
        }
        
        try {
            rs = co.createStatement().executeQuery("SELECT * FROM user");
            while (rs.next()) {
                users.add(new Utilisateur(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8)));                
            }
            rs.close();
        } catch (SQLException SQLException) {
            System.out.println("Erreur chargement sql!");
        }
        return users;        
    }
     public static void updateStatut(Utilisateur user){
        sql="UPDATE user SET statut=? WHERE pseudo=?";
        try{
            pst=co.prepareStatement(sql);
            if(user.getStatut()==null){
                user.setStatut("LIGNE");
            }
            else{
                if(user.getStatut()==Etat.HORS_LIGNE){
                    user.setStatut("LIGNE");
                }  
                else{
                    user.setStatut("HORS_LIGNE");
                }
            }
            pst.setString(1, user.getStatut().toString());
            pst.setString(2, user.getPseudo());
            pst.executeUpdate();
            pst.close();
        }
        catch(Exception e){
            System.err.println("Erreur de Maj du statut\n");
            e.printStackTrace();
        }
    }
    public static Utilisateur findUserByPseudo(String pseudo){
        Utilisateur user=null;
        if(co==null){
            System.out.println("Connexion Null");
            exit(1);
        }
        try{
            pst=co.prepareStatement("SELECT * FROM user WHERE pseudo=?");
            pst.setString(1, pseudo);
            rs=pst.executeQuery();
            if(rs.next()){
                
            }
            Iterator it=users.iterator();
            int i=0;
            while(it.hasNext()){
                if(users.get(i).getPseudo().equals(rs.getString("pseudo"))){
                    pst.close();
                    return users.get(i);
                }
                i++;
                it.next();
            }
            rs.close();
            pst.close();
        }
        catch(SQLException sQLException){
            System.out.println("Erreur aucun utilisateur");
            System.out.println(sQLException);
            
        }
        return user;
    }
}
