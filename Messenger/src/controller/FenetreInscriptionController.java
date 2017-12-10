/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static DAL.UserGateway.insertUser;
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
        
        if(!txtPassword.getText().equals(txtPassword2.getText())){
            Alert alertMdp = new Alert(Alert.AlertType.INFORMATION);
            alertMdp.setTitle("Attention");
            alertMdp.setContentText("Les mots de passe ne correspondent pas.");
            alertMdp.setHeaderText(null);
            alertMdp.showAndWait();
        }
        insertUser(txtNom.getText(),txtPrenom.getText(), txtPseudo.getText(), txtPassword.getText(), txtAdresse.getText(),txtTel.getText());
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
