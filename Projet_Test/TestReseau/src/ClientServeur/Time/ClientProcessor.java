/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientServeur.Time;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.text.DateFormat;
import java.util.Date;

/**
 *
 * @author thyzavard
 */
public class ClientProcessor implements Runnable{

    private Socket sock;
    private PrintWriter writer = null;
    private BufferedInputStream reader = null;
    
    public ClientProcessor(Socket pSock){
        sock = pSock;
    }
    
    public void run(){
        System.err.println("Lancement du traitement de la connexion cliente");
        
        boolean closeConnexion = false;
        
        while(!sock.isClosed()){
            try{
                
                writer = new PrintWriter(sock.getOutputStream());
                reader = new BufferedInputStream(sock.getInputStream());
                
                String reponse = read();
                InetSocketAddress remote = (InetSocketAddress)sock.getRemoteSocketAddress();
                
                String debug = "";
                debug = "Thread : " + Thread.currentThread().getName() + ".";
                debug += "Demande de l'adresse : " + remote.getAddress().getHostAddress() + ".";
                debug += "Sur le port : "+ remote.getPort() + ".\n";
                debug += "\t -> Commande reçu : "+reponse+".\n";
                System.err.println("\n");
                
                String toSend = "";
                
                switch(reponse.toUpperCase()){
                    case "FULL":
                        toSend = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.MEDIUM).format(new Date());
                        break;
                    case "DATE":
                        toSend = DateFormat.getDateInstance(DateFormat.FULL).format(new Date());
                        break;
                    case "HOUR":
                        toSend = DateFormat.getDateInstance(DateFormat.MEDIUM).format(new Date());
                        break;
                    case "CLOSE":
                        toSend = "Communication terminée";
                        closeConnexion = true;
                        break;
                    default:
                        toSend = "Commande inconnu !";
                        break;
                        
                }
                
                writer.write(toSend);
                
                writer.flush();
                
                if(closeConnexion){
                    System.err.println("COMMANDE CLOSE DETECTEE !");
                    writer = null;
                    reader = null;
                    sock.close();
                    break;
                }
            } catch(SocketException e){
                System.err.println("LA CONNEXION A ETE INTERROMPUE ! ");
                break;
            } catch (IOException e) {
                e.printStackTrace();
            } 
        }
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
