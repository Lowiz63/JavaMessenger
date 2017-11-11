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
import javafx.geometry.Pos;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Thomas
 */
public class FenetreInscriptionController implements Initializable {

    @FXML
    private Label testcenter;
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        testcenter.setAlignment(Pos.CENTER);
    }    
    
}
