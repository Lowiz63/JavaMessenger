/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testthread;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;

/**
 *
 * @author lulauriche
 */
public class Controlleur2 {
    
    //private int nb =100;
    private Thread t;
    @FXML
    Label lbNB;
    
    @FXML
    public void initialize() throws InterruptedException{
        t = new Thread(new ImplRunnable());
        t.start();
    }
    
    
    @FXML
    public void annuler(Event e){
        ((Node)e.getSource()).getScene().getWindow().hide();
        Thread.currentThread().interrupt();
    }
}
