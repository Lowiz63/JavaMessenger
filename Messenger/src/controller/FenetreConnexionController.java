/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import modèle.DbConnection;
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
    private DbConnection dc;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        msgerror.setVisible(false);
        dc = new DbConnection();
         try {
            Connection conn = dc.Connect();
            if(conn==null){
                System.out.println("c'est null ptn !!");
            }
              users = FXCollections.observableArrayList();
            // Execute query and store result in a resultset
            //ResultSet rs = conn.prepareStatement("SELECT * FROM User").executeQuery();
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM User");
            while (rs.next()) {
                users.add(new Utilisateur(rs.getString(1),rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6),rs.getString(7)));   
            }

        } catch (SQLException ex) {
            System.err.println("Error"+ex);
        }
        // TODO
    }    

    
    @FXML
    public void openMain(Event event) throws IOException{
      
         if(verification(txtPseudo.getText(),txtPassword.getText())){
            ((Node)event.getSource()).getScene().getWindow().hide();
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/ihm/MainWindow.fxml"));
            stage.setScene(new Scene(root,430,500));
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
        stage.setAlwaysOnTop(true);
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
    
    public  Boolean verification(String username, String mdp){
        Iterator it=users.iterator();
        int i=0;
        while(it.hasNext()){
            if(users.get(i).getPseudo().equals(username)&&users.get(i).getMdp().equals(mdp)){
                return true;
            }
            i++;
            it.next();
        }
        return false;
    }
}
