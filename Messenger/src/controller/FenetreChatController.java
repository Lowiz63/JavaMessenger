/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

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
        t = new Thread(new RunnableChat());
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
