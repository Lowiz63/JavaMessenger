/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testthread;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author lulauriche
 */
public class Controller1 {
    @FXML
    public void decompteWin(ActionEvent e) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/testthread/Decompte.fxml"));
        Scene scene = new Scene(root,500,500);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}
