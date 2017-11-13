/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientServeur.Time;

/**
 *
 * @author thyzavard
 */
public class Main {
    
    public static void main(String[] args){
        String host = "127.0.0.1";
        int port = 2345;
        
        TimeServer ts = new TimeServer(host, port);
        ts.open();
        
        System.out.println("Serveur initialisé.");
        
        for(int i=0 ; i<5 ; i++){
            Thread t = new Thread(new ClientConnexion(host, port));
            t.start();
        }
    }
    
}
