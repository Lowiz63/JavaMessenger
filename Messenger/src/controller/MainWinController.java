/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import modèle.Utilisateur;

/**
 *
 * @author blood
 */
public class MainWinController {
    @FXML    private Label lbPseudo;
    
    @FXML    private ListView<Utilisateur> lvContact= new ListView<>();
    
    @FXML    private MenuButton statut;
    
    @FXML    private Image imgetat;
    //pas effective
    ObservableList<Utilisateur> lcontacts= FXCollections.observableArrayList();
    private ListProperty<Utilisateur> listContactProperty = new SimpleListProperty<>(lcontacts);
    
    @FXML
    public void initialize(URL url, ResourceBundle rb){
        lbPseudo.setText("Pseudo Contact"); 
        bindingLW();
    }
    
    protected void bindingLW(){
        lvContact.itemsProperty().bind(listContactProperty);        
        
        lvContact.setCellFactory(unused -> new ListCell<Utilisateur>(){
            @Override
            protected void updateItem(Utilisateur item, boolean empty) {
                super.updateItem(item, empty);
                if(!isEmpty()){
                    textProperty().bind(item.pseudoProperty());
                }else{
                    textProperty().unbind();
                    textProperty().setValue(null);
                }
            }
        });
        lvContact.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener<Utilisateur>() {
                    public void changed(ObservableValue<? extends Utilisateur> observable,
                                        Utilisateur oldValue, Utilisateur newValue) {
                        if(newValue!=null)
                            try {
                                newChat();
                        } catch (IOException ex) {
                            Logger.getLogger(MainWinController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
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
    
    public void Confirme(Event event) throws IOException{
        ((Node)event.getSource()).getScene().getWindow().hide();
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/ihm/FenetreConnexion.fxml"));
        stage.setScene(new Scene(root));
        stage.setResizable(false);
            stage.centerOnScreen();
            stage.setTitle("Java Messenger - Profil");
            stage.show();
        
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
    
    public void newChat() throws IOException{
        Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/ihm/FenetreChat.fxml"));
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.setTitle("Java Messenger - Chat");
        stage.show();
    }
    
    
}
