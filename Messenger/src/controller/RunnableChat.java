/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static managers.ThreadManager.addThread;
import modèle.Contact;

/**
 *
 * @author blood
 */
public class RunnableChat implements Runnable {
    private Thread currentT;
    private Contact contact;
    
    public RunnableChat(Contact c) throws IOException{
        //this.contact=c;
        //contact.lancerServeur();
        //contact.lancerClient();
    }
    
    @Override
    public void run() {
        currentT = Thread.currentThread();
        addThread(currentT);
        /*while(true){
            
            try {
                contact.envoyerServeur();
                contact.recevoirClient();
                contact.envoyerClient();
                contact.recevoirServeur();
            } catch (IOException ex) {
                Logger.getLogger(RunnableChat.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }*/
            
    }
    
}
