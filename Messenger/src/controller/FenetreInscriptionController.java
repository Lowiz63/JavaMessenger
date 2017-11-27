/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modèle.DbConnection;

/**
 * FXML Controller class
 *
 * @author Thomas
 */
public class FenetreInscriptionController implements Initializable {

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
    
    private Connection conn = null;
    private PreparedStatement pst = null;
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
    
    public void onExit(ActionEvent event){
        try {
            ((Node)event.getSource()).getScene().getWindow().hide();
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/ihm/FenetreConnexion.fxml"));
            stage.setScene(new Scene(root,500,400));
            stage.setResizable(false);
            stage.centerOnScreen();
            stage.setTitle("Java Messenger - Connexion");
            stage.show();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setContentText("");
            alert.showAndWait();
        }
    }
    
     @FXML
    public void onInscription(Event event) throws SQLException, IOException{
        conn = DbConnection.Connect();
        String sql="Insert into User(nom,prenom,pseudo,mdp,adresse,Tel) Values(?,?,?,?,?,?);";
        String nom = txtNom.getText();
        String prenom = txtPrenom.getText();
        String pseudo = txtPseudo.getText();
        String password = txtPassword.getText();
        String password2 = txtPassword2.getText();
        String adresse = txtAdresse.getText();
        String tele = txtTel.getText();
        
        if(!txtPassword.getText().equals(txtPassword2.getText())){
            Alert alertMdp = new Alert(Alert.AlertType.INFORMATION);
            alertMdp.setTitle("Attention");
            alertMdp.setContentText("Les mots de passe ne correspondent pas.");
            alertMdp.setHeaderText(null);
            alertMdp.showAndWait();
        }
        
        try {
            pst = conn.prepareStatement(sql);
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
             Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/ihm/MainWindow.fxml"));
            stage.setScene(new Scene(root,500,400));
            stage.setResizable(false);
            stage.centerOnScreen();
            stage.setTitle("Java Messenger - Connexion");
            stage.show();
        }

    }
    
    
    
}
