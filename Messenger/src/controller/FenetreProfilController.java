/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import modèle.Utilisateur;

/**
 *
 * @author pereiraloann
 */
public class FenetreProfilController {
    
    @FXML
    public Label nom;
    @FXML
    public Label prenom;
    @FXML
    public Label pseudo;
    @FXML
    public Label adresse;
    @FXML
    public Label tel;
    
    Utilisateur user;

    
    public void getUserProfil(Utilisateur us){
         nom.setText(us.getNom());
        prenom.setText(us.getPrenom());
        pseudo.setText(us.getPseudo());
        adresse.setText(us.getAdresse());
        tel.setText(us.getTel());

    }
    

    
    public void onExit(Event event){
        ((Node)event.getSource()).getScene().getWindow().hide();
    }
    
}
