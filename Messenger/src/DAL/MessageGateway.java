/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import static DAL.UserGateway.findUserByPseudo;
import controller.FenetreInscriptionController;
import static java.lang.System.exit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modèle.DbConnection;
import modèle.Message;
import modèle.Utilisateur;

/**
 *
 * @author ludo
 */
public class MessageGateway {
    private static Connection co=DbConnection.Connect();;
    private static PreparedStatement pst;
    
     public static void insertMessage(String id,String contenu,Utilisateur auteur,Utilisateur dest){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date=new Date();
        if(co==null){
            System.out.println("Connexion Null");
            exit(1);
        }
        try {
            String sql="Insert into Message(idMessage,contenu,date,PseudoAuteur,pseudoDest) Values(?,?,?,?,?);";
        
            pst = co.prepareStatement(sql);
            pst.setString(1,id );
            pst.setString(2,contenu );
            pst.setString(3,dateFormat.format(date));
            pst.setString(4,auteur.getPseudo());
            pst.setString(5,dest.getPseudo());
            
            int i = pst.executeUpdate();
            if (i ==1)System.out.println("Message ajouter a la base de donnée");
            pst.close();
            
            // youtube: https://www.youtube.com/watch?v=jGJqVRTcDWI vers 30min
        } 
        catch (SQLException ex) {
            Logger.getLogger(FenetreInscriptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    public static ObservableList<Message> initializeMessage(Utilisateur sender, Utilisateur receiver){
        ObservableList<Message> lMessage = FXCollections.observableArrayList();
        if(co==null){
            System.out.println("Connexion Null");
            exit(1);
        }        
        try {
            ResultSet rs = co.createStatement().executeQuery("SELECT * FROM Message WHERE PseudoAuteur=? AND pseudoDest=?");
            while (rs.next()) {
                Utilisateur auteur=findUserByPseudo(rs.getString(4));
                Utilisateur destinataire=findUserByPseudo(rs.getString(5));
                lMessage.add(new Message(rs.getString(1), rs.getString(2), rs.getString(3), auteur , destinataire));                
            }
        } catch (SQLException sQLException) {
            System.out.println("Erreur sql ajout de message");
        }
        return lMessage;
        
    }
}
