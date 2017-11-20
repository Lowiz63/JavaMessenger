/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youtubeuser;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;

/**
 *
 * @author lopereira2
 */
public class FenetreInscriptionController{
    @FXML
    private TextField txtNom;
    @FXML
    private TextField txtPrenom;
    @FXML
    private TextField txtPseudo;
    @FXML
    private TextField txtPassword;
    @FXML
    private TextField txtPassword2;
    @FXML
    private TextField txtAdresse;
    @FXML
    private TextField txtTel;
    
    private Connection con = null;
    private PreparedStatement pst = null;
    
    @FXML
    public void onAdd(Event event) throws SQLException{
        con = DbConnection.Connect();
        String sql="Insert into User(nom,prenom,pseudo,mdp,adresse,Tel) Values(?,?,?,?,?,?);";
        String nom = txtNom.getText();
        String prenom = txtPrenom.getText();
        String pseudo = txtPseudo.getText();
        String password = txtPassword.getText();
        String password2 = txtPassword2.getText();
        String adresse = txtAdresse.getText();
        String tele = txtTel.getText();
        
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, nom);
            pst.setString(2, prenom);
            pst.setString(3, pseudo);
            pst.setString(4, password);
            pst.setString(5, adresse);
            pst.setString(6, tele);
            
            int i = pst.executeUpdate();
            if ( i ==1)
                System.out.println("Utilisateur ajouter avec succès");
            
            // youtube: https://www.youtube.com/watch?v=jGJqVRTcDWI vers 30min
        } catch (SQLException ex) {
            Logger.getLogger(FenetreInscriptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            pst.close();
            ((Node)event.getSource()).getScene().getWindow().hide();
        }

    }
    
    

    
    public void onExit(Event event){
        ((Node)event.getSource()).getScene().getWindow().hide();
    }
    
    
}
