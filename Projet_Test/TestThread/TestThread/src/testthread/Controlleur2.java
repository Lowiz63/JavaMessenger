/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testthread;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;

/**
 *
 * @author lulauriche
 */
public class Controlleur2{
    @FXML
    private Thread t;
    @FXML
    Label lbNB;
    private StringProperty compteurProperty = new SimpleStringProperty();

    public StringProperty getCompteurProperty() {
        return compteurProperty;
    }

    public void setCompteurProperty(StringProperty compteurProperty) {
        this.compteurProperty = compteurProperty;
    }
    public String getCompteur(){
        return compteurProperty.get();
    }
    
    
    @FXML
    public void initialize() throws InterruptedException{
        t = new Thread(new ImplRunnable());
        t.start();
    }
    
    @FXML
    public synchronized void decompte() throws InterruptedException{
        int i=0;
    
        for(i=10; i>0;i--){
            System.out.println(i);
            //lbNB.TextProperty().bind(this.compteurProperty);
            t.sleep(1000);
        }
        
        
    }
    
    
    @FXML
    public void annuler(Event e){
        ((Node)e.getSource()).getScene().getWindow().hide();
        t.interrupt();
    }

}
