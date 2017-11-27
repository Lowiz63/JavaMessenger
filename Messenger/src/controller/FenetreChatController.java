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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import modèle.Contact;

/**
 * FXML Controller class
 *
 * @author thyzavard
 */
public class FenetreChatController implements Initializable {
    @FXML private Thread t;
    @FXML private Label lblPseudoContact;
    @FXML private TextArea txtMessage;
    @FXML private ListView lvConversation;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            t = new Thread(new RunnableChat(new Contact("nom", "prenom", "adresse", "login","mdp","statut")));
        } catch (IOException ex) {
            Logger.getLogger(FenetreChatController.class.getName()).log(Level.SEVERE, null, ex);
        }
        t.start();
    }    
    
    public void onEnvoyerMessage(){
        lvConversation.getItems().add(txtMessage.getText());
        txtMessage.setText("");
        
    }
    public void quitConv(ActionEvent e){
        ((Node)e.getSource()).getScene().getWindow().hide();
        System.out.println(t+" s'est stoppé");
        t.interrupt();
        
    }
    
    /*public void onPressedEnter(KeyEvent e){
        if(e.getCode() == KeyCode.ENTER){
           onEnvoyerMessage();
        }
        System.out.println("onPressedEnter");
    }*/
    
}
