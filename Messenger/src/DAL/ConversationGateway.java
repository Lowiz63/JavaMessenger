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
import java.sql.SQLException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import modèle.DbConnection;
import modèle.Message;
import modèle.Utilisateur;

/**
 *
 * @author ludod
 */
public class ConversationGateway {
    private static Connection co=DbConnection.Connect();;
    private static PreparedStatement pst;
    
    public static void insertConversation(Utilisateur sender,Utilisateur receiver,ObservableList<Message> chat){
        String squery="INSERT INTO CONVERSATION(pseudoS,pseudoR,message) VALUES(?,?,?)";
        if(co==null){
            System.out.println("Connexion Null");
            exit(1);
        }
        try{
            pst=co.prepareStatement(squery);
            pst.setString(1,sender.getPseudo());
            pst.setString(2,receiver.getPseudo());
            Iterator<Message> iterator = chat.iterator(); 
            while(iterator.hasNext()) {
                Message msg=iterator.next();
                pst.setString(3, msg.getIdMessage());                
            }
        }
        catch(SQLException ex) {
            Logger.getLogger(FenetreInscriptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    public static void initializeConversation(){
        
        if(co==null){
            System.out.println("Connexion Null");
            exit(1);
        }
        
    }
}
