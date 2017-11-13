/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testthread;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;

/**
 *
 * @author lulauriche
 */
public class ImplRunnable extends Controlleur2 implements Runnable {
    int nb=100;
    Thread t = Thread.currentThread();
    public ImplRunnable(){        
    }
    
    @Override
    public void run() {
        try {
            decompte();
        } catch (InterruptedException ex) {
            Logger.getLogger(ImplRunnable.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @FXML
    public void decompte() throws InterruptedException{
        for(int i=0; i<100;i++){
            nb--;
            lbNB.setText("reste : "+ nb);
            t.sleep(1000);
        }
        lbNB.setText("BOOM!");
    }
    
}
