/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static DAL.UserGateway.initializeUsers;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static managers.Validation.validationUser;
import modèle.Utilisateur;

/**
 * FXML Controller class
 *
 * @author Thomas
 */
public class FenetreConnexionController implements Initializable {
    
    @FXML
    private TextField txtPseudo;
    @FXML
    private PasswordField txtPassword;
    
    @FXML 
    private Label msgerror;
    
    private ObservableList<Utilisateur> users;
    private Utilisateur user;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        msgerror.setVisible(false);
        users = initializeUsers(); 
    }    

    
    @FXML
    public void openMain(Event event) throws IOException{
      user=validationUser(txtPseudo.getText(),txtPassword.getText(),users);
           MainWinController f;
         if(user!=null){
            ((Node)event.getSource()).getScene().getWindow().hide();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ihm/MainWindow.fxml"));
            stage.setScene(new Scene(loader.load()));
            f=loader.getController();
            f.getUser(user);
            stage.setResizable(false);
            stage.centerOnScreen();
            stage.setTitle("Java Messenger - Page d'acceuil");
            stage.show();
            
        
        }
        else{
            showError();
        }
        
        
 

    }
    
    public void openInscription(Event event) throws IOException{
        ((Node)event.getSource()).getScene().getWindow().hide();
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/ihm/FenetreInscription.fxml"));
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.setTitle("Java Messenger - Inscription");
            
        stage.show();
    }
    
    public void onExit(Event e){
        Platform.exit();
    }
    
   
    public void showError(){
        msgerror.setVisible(true);
    }
}
