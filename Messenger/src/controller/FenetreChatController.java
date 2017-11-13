/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author thyzavard
 */
public class FenetreChatController implements Initializable {

    @FXML private Label lblPseudoContact;
    @FXML private TextArea txtMessage;
    @FXML private ListView lvConversation;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    public void onEnvoyerMessage(){
        System.out.println("onEnvoyerMessage");
        lvConversation.getItems().add(txtMessage.getText());
        txtMessage.setText("");
        
    }
    
    /*public void onPressedEnter(KeyEvent e){
        if(e.getCode() == KeyCode.ENTER){
           onEnvoyerMessage();
        }
        System.out.println("onPressedEnter");
    }*/
    
}
