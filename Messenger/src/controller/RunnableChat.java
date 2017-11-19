/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.application.Platform;

/**
 *
 * @author blood
 */
public class RunnableChat extends FenetreChatController implements Runnable {
    private Thread t;
    
    public RunnableChat(){
        t = Thread.currentThread();
    }
    
    @Override
    public void run() {
            System.out.println(t+" est en cours ");
            
    }
    
}
