/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author blood
 */
public class ThreadManager {
    static List<Thread> listRunningThread = new ArrayList<>();
    
    public static void addThread(Thread threadAdded){
        
        listRunningThread.add(threadAdded);
        System.out.println(threadAdded+" Ajouté");
        
    }
    
    public static void stopThread(){
        if(listRunningThread!=null){
            for(Thread t : listRunningThread){
                System.out.println(t+" Stoppé");
                t.interrupt();
            }
        }
    }
}
