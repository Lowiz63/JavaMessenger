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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author blood
 */
public class MainWinController {
    @FXML
    private Label lbPseudo;
    
    @FXML
    private MenuButton statut;
    
    @FXML
    private Image imgetat;
    
    public void initialize(URL url, ResourceBundle rb){
        lbPseudo.setText("Pseudo Contact");
    }
    
    public void onExit(Event event) throws IOException{
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/ihm/confirmation.fxml"));
        stage.setScene(new Scene(root));
        stage.setResizable(false);
            stage.centerOnScreen();
            stage.setTitle("Java Messenger - Confirmation");
            stage.show();
    }
    
    public void Confirme(Event event){
        ((Node)event.getSource()).getScene().getWindow().hide();
        Quitter();
    }
    
    public void Quitter(){
        Platform.exit();
    }
    
    public void Annuler(Event event){
        ((Node)event.getSource()).getScene().getWindow().hide();
    }
    
    
    public void enLigne(){
        statut.setText("En Ligne");
        
        
    }
    public void occupe(){
        statut.setText("Occupé");
    }
    public void horsLigne(){
        statut.setText("Hors ligne");
    }

    public void goProfil(Event event) throws IOException{
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/ihm/FenetreProfil.fxml"));
        stage.setScene(new Scene(root));
        stage.setResizable(false);
            stage.centerOnScreen();
            stage.setTitle("Java Messenger - Profil");
            stage.show();
    }
    
    
}
