/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modèle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author blood
 */
public class Contact extends Utilisateur implements Client, Serveur {
    ServerSocket socketServer;
    Socket socketduServeur, socketClient;
    BufferedReader inS,inC;
    PrintWriter outS,outC;
    Scanner saisie;
    
    public Contact(String nom, String prenom, String adresse,String login, String mdp,String tel ) throws IOException{
        super(nom, prenom,login, mdp, adresse,tel, 2048);
        saisie = new Scanner(System.in);
        socketServer = new ServerSocket(2345);        
    }
    @Override
    public void lancerServeur() throws IOException{
        socketduServeur = socketServer.accept();
        outS = new PrintWriter (socketduServeur.getOutputStream ());
        inS = new BufferedReader (new InputStreamReader (socketduServeur.getInputStream ()));
    }
    @Override
    public void envoyerServeur(){
        String s;
        s = saisie.next ();
        System.out.println (s);
        outS.flush ();
    }
    @Override
    public void recevoirServeur() throws IOException{
        String receivedmessage;
        receivedmessage= inS.readLine();
        System.out.println ("Client:" + receivedmessage);
    }
    @Override
    public void lancerClient()throws IOException{
        socketClient= new Socket("127.0.0.1",2345);
        outC = new PrintWriter (socketClient.getOutputStream ());
        inC = new BufferedReader (new InputStreamReader (socketClient.getInputStream ()));
    }
    @Override
    public void envoyerClient(){
        String s;
        s = saisie.next ();
        System.out.println (s);
        outC.flush ();
    }
    @Override
    public void recevoirClient() throws IOException{
        String receivedmessage;
        receivedmessage= inC.readLine();
        System.out.println ("Serveur:" + receivedmessage);
    }

    
    
}
