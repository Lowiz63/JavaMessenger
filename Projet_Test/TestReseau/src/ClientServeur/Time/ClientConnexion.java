/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientServeur.Time;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;

/**
 *
 * @author thyzavard
 */
public class ClientConnexion implements Runnable{
    
    private Socket connexion = null;
    private PrintWriter writer = null;
    private BufferedInputStream reader = null;
    
    private String[] listCommands = { "FULL", "DATE", "HOUR", "NONE"};
    private static int count = 0;
    private String name ="Client-";
    
    public ClientConnexion(String host, int port){
        name += ++count;
        try{
            connexion = new Socket(host, port);
        } catch (UnknownHostException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    
    public void run(){
        
        for(int i=0 ; i<10 ; i++){
            try{
                Thread.currentThread().sleep(1000);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
            
            try{
                writer = new PrintWriter(connexion.getOutputStream(), true);
                reader = new BufferedInputStream(connexion.getInputStream());
                
                String commande = getCommand();
                writer.write(commande);
                writer.flush();
                
                System.out.println("Commande "+commande+" envoyée au serveur");
                
                String reponse = read();
                System.out.println("\t * "+name+" : Reponse reçue "+reponse);
            } catch (IOException e1){
                e1.printStackTrace();
            }
            
            try{
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        writer.write("CLOSE");
        writer.flush();
        writer.close();
    }
    
    private String getCommand(){
        Random rand = new Random();
        return listCommands[rand.nextInt(listCommands.length)];
    }
    
    private String read() throws IOException{
        String reponse = "";
        int stream;
        byte[] b = new byte[4096];
        stream = reader.read(b);
        reponse = new String(b, 0, stream);
        return reponse;
        
    }
    
}
