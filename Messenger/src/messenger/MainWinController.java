/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messenger;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 *
 * @author blood
 */
public class MainWinController {
    @FXML
    Label lbPseudo;
    
    @FXML
    private void initialize(){
        lbPseudo.setText("Pseudo Contact");
    }
}
