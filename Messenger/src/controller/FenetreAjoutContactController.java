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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Thomas
 */
public class FenetreAjoutContactController implements Initializable {

    @FXML private TextField txtPseudoAjout;
    @FXML private TextField txtMessageAjout;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void onAjoutContact(ActionEvent event){
        
    }
    
    public void onExit(ActionEvent event){
        ((Node)event.getSource()).getScene().getWindow().hide();
    }
    
}