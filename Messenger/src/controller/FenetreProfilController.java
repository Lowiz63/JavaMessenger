/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author pereiraloann
 */
public class FenetreProfilController {
    
    
    public void goMenu(Event event) throws IOException{
        ((Node)event.getSource()).getScene().getWindow().hide();
        
    }
    
    
}
