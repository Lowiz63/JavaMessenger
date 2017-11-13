/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientServeur.Time;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author thyzavard
 */
public class TimeServer {

    private int port = 2345;
    private String host = "127.0.0.1";
    private ServerSocket server = null;
    private boolean isRunning = true;
    
    public TimeServer(){
        try{
            server = new ServerSocket(port, 100, InetAddress.getByName(host));
        } catch(UnknownHostException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public TimeServer(String pHost, int pPort){
        host = pHost;
        port = pPort;
        try{
            server = new ServerSocket(port, 100, InetAddress.getByName(host));
        } catch(UnknownHostException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void open(){
        Thread t = new Thread(new Runnable(){
           public void run(){
               while(isRunning == true){
                   try{
                       Socket client = server.accept();
                       
                       System.out.println("Connexion cliente reçu");
                       Thread t = new Thread(new ClientProcessor(client));
                       t.start();
                   } catch(IOException e){
                       e.printStackTrace();
                   }
               }
               try{
                   server.close();
               } catch(IOException e){
                   e.printStackTrace();
                   server = null;
               }
           } 
        });
        t.start();
    }
    
    public void close(){
        isRunning = false;
    }
    
}
