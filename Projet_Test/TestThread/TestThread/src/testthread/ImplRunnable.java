/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testthread;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 *
 * @author lulauriche
 */
public class ImplRunnable extends Controlleur2 implements Runnable {
    int nb;
    Thread t; 
    int i=0;
    
    
    public ImplRunnable(){
        t = Thread.currentThread();
        nb = 100;
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
    public synchronized void decompte() throws InterruptedException{
        for(i=0; i<100;i++){
            nb--;
            System.out.println(i);
            //lbNB.setText("reste : "+ nb);
            if(stoped){
                t.interrupt();
            }
            t.sleep(1000);
        }
        //lbNB.setText("BOOM!");
        
        
    }
    
}
