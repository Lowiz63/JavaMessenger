/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void openMain(Event event) throws IOException{
        if(txtPseudo.getText().equals("user") && txtPassword.getText().equals("pass")){
            ((Node)event.getSource()).getScene().getWindow().hide();
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/ihm/MainWindow.fxml"));
            stage.setScene(new Scene(root,430,500));
            stage.setResizable(false);
            stage.centerOnScreen();
            stage.setTitle("Java Messenger - Inscription");
            
            stage.show();
        }
    }
    
    public void openInscription(Event event) throws IOException{
        ((Node)event.getSource()).getScene().getWindow().hide();
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/ihm/FenetreInscription.fxml"));
        stage.setScene(new Scene(root,430,500));
            
        stage.setAlwaysOnTop(true);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.setTitle("Java Messenger - Inscription");
            
        stage.show();
    }
    
    public void onExit(Event e){
        Platform.exit();
    }
    
}
