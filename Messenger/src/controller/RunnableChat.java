/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Label;
import static managers.ThreadManager.addThread;
import modèle.Contact;

/**
 *
 * @author blood
 */
public class RunnableChat extends Thread {
    private Contact contact;
    private Label lbPseudo;
    
    public RunnableChat(Contact c,Label lb){
        this.contact=c;
        this.lbPseudo= lb;
    }
    
    @Override
    public void run() {
            lbPseudo.textProperty().bind(contact.pseudoProperty());
    }
    
}
