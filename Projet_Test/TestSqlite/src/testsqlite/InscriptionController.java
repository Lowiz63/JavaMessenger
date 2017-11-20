/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testsqlite;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author thyzavard
 */
public class InscriptionController implements Initializable {

    public InscriptionModel inscriptionModel = new InscriptionModel();
    
    @FXML private Label isConnected;
    @FXML private TextField txtPseudo;
    @FXML private TextField txtMdp;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(inscriptionModel.isDbConnected()){
            isConnected.setText("Connected");
        } else{
            isConnected.setText("Not Connected");
        }
    }    
    
    public void inscrire() throws SQLException{
        if(txtPseudo.getText() != null && txtMdp.getText() != null){
            inscriptionModel.insert(txtPseudo.getText(), txtMdp.getText());
        }
    }
    
}
