/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAL.ContactGateway;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modèle.Utilisateur;

/**
 * FXML Controller class
 *
 * @author Thomas
 */
public class FenetreAjoutContactController implements Initializable {

    @FXML private TextField txtPseudoAjout;
    @FXML private TextField txtMessageAjout;
    @FXML private Label add;
    @FXML private Label error;
    private Utilisateur user;

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        add.setVisible(false);
        error.setVisible(false);
    }    
    
    public void onAjoutContact(ActionEvent event){
        try{
        if(ContactGateway.insertContact(user, txtPseudoAjout.getText())){
            txtPseudoAjout.setText("");
            error.setVisible(false);
            add.setVisible(true);
        }
        else{
            error.setVisible(true);
            add.setVisible(false);
        }
        
        
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void onExit(ActionEvent event){
        ((Node)event.getSource()).getScene().getWindow().hide();
    }
    
}
