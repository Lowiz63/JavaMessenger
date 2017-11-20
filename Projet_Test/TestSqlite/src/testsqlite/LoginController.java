/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testsqlite;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author thyzavard
 */
public class LoginController implements Initializable {

    public LoginModel loginModel = new LoginModel();
    
    @FXML private Label isConnected;
    @FXML private TextField txtPseudo;
    @FXML private TextField txtMdp;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(loginModel.isDbConnected()){
            isConnected.setText("Connected");
        } else{
            isConnected.setText("Not Connected");
        }
    }    
    
    public void Login(ActionEvent event){
        try {
            if(loginModel.isLogin(txtPseudo.getText(), txtMdp.getText())){
                isConnected.setText("Pseudo et mdp correct");
                ((Node)event.getSource()).getScene().getWindow().hide();
                Stage primaryStage = new Stage();
                FXMLLoader loader = new FXMLLoader();
                Pane root = loader.load(getClass().getResource("User.fxml").openStream());
                UserController userController = (UserController)loader.getController();
                userController.getUser(txtPseudo.getText());
                Scene scene = new Scene(root);
                primaryStage.setScene(scene);
                primaryStage.show();
                
            } else {
                isConnected.setText("Pseudo et mdp incorrect");
            }
        } catch (SQLException e) {
            isConnected.setText("Pseudo et mdp incorrect");
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void inscription(ActionEvent event){
        try {
            ((Node)event.getSource()).getScene().getWindow().hide();
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("inscription.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
