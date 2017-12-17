/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static DAL.UserGateway.findUserByPseudo;
import static DAL.UserGateway.updateStatut;
import Server.Server;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
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
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import managers.ThreadManager;
import modèle.Utilisateur;

/**
 *
 * @author blood
 */
public class MainWinController implements Initializable{
    @FXML    private Label pseudo;
    
    @FXML    private ListView<Utilisateur> lvContact= new ListView<>();
    
    @FXML    private MenuButton statut;
    
    @FXML    private ImageView imgetat;

    
    public Utilisateur currentUser;
    public ObservableList<Utilisateur> lcontacts;
    public Thread th;
    public Utilisateur currentContact;
    
    @FXML
    public void initialize(URL url, ResourceBundle rb){
    }
    
    
    protected void bindingLW(){
        lvContact.setItems(lcontacts);
        lvContact.setCellFactory((param) -> {
            return new ListCell<Utilisateur>(){
               @Override
                protected void updateItem(Utilisateur user, boolean empty) {
                    super.updateItem(user, empty);
                    if (!empty) {
                        textProperty().bind(user.pseudoProperty());
                    } else {
                        textProperty().unbind();
                        setText("");
                    }
                }  
            };
        });
        lvContact.getSelectionModel().selectedItemProperty().addListener((o,old,newV)->{
            if(newV!=null)
                    try {
                        currentContact= newV;
                        newChat();
                } catch (IOException ex) {
                    Logger.getLogger(MainWinController.class.getName()).log(Level.SEVERE, null, ex);
                }
        });
        
        
        pseudo.textProperty().bind(currentUser.pseudoProperty());
    }
  
    
    public void onExit(Event event) throws IOException{
        //Platform.exit();
        Alert alertDeco = new Alert(Alert.AlertType.CONFIRMATION);
        alertDeco.setTitle("Deconnexion");
        alertDeco.setContentText("Voulez vous vraiment vous déconnecter ?");
        alertDeco.setHeaderText(null);
        Optional<ButtonType> result = alertDeco.showAndWait();
        if (result.get() == ButtonType.OK){
            updateStatut(currentUser);
            Platform.exit();
        }
    }
    
    public void Quitter(){
        Platform.exit();
    }
    
    public void Annuler(Event event){
        ((Node)event.getSource()).getScene().getWindow().hide();
    }
    
    
    public void enLigne(){
        statut.setText("En Ligne");  
        Image ligne = new Image("/Images/img_en_ligne.png");
        imgetat.setImage(ligne);
    }
    public void occupe(){
        statut.setText("Occupé");
        Image occupe = new Image("/Images/img_occupe.png");
        imgetat.setImage(occupe);

    }
    public void horsLigne(){
        statut.setText("Hors ligne");
        Image hors_ligne = new Image("/Images/img_hors_connexion.png");
        imgetat.setImage(hors_ligne);
    }

    public void goProfil(Event event) throws IOException{
       // System.out.println("usergoprofil:"+currentUser);
        FenetreProfilController f;
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ihm/FenetreProfil.fxml"));
        stage.setScene(new Scene(loader.load()));
        f=loader.getController();
        f.getUserProfil(this.currentUser);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.setTitle("Java Messenger - Votre profil");
        stage.show();
    }
    
    public void newChat() throws IOException{
        FenetreChatController f;
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ihm/FenetreChat.fxml"));
        stage.setScene(new Scene(loader.load()));
        f=loader.getController();
        f.lancement(currentUser,currentContact);
        
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.setTitle("Java Messenger - Conversation");
        stage.show();
    }
    
    public void getUser(Utilisateur user){
        currentUser=user;
        this.lcontacts=currentUser.getListContact();
        bindingLW();
        System.out.println("port:"+currentUser.getPort());
        th = new Thread(() -> {
            new Server(currentUser.getPort());
        });
        ThreadManager.addThread(th);
        th.start();
    }
    public void onContact() throws IOException{
        FenetreAjoutContactController f;
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ihm/FenetreAjoutContact.fxml"));
        stage.setScene(new Scene(loader.load()));
        f=loader.getController();
        f.setUser(this.currentUser);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.setTitle("Java Messenger - Votre porfil");
        stage.show();
    }
    
}
