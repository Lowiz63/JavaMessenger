/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static managers.ThreadManager.addThread;

/**
 *
 * @author blood
 */
public class RunnableChat extends FenetreChatController implements Runnable {
    private Thread currentT;
    
    public RunnableChat(){
        currentT = Thread.currentThread();
        addThread(currentT);
    }
    
    @Override
    public void run() {
            
            
    }
    
}
