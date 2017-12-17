/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import modèle.Utilisateur;

/**
 * FXML Controller class
 *
 * @author thyzavard
 */
public class FenetreChatController {
    @FXML private Label lblPseudoContact;
    @FXML private TextField txtMessage;
    @FXML private TextArea lvConversation;
    
    public static Thread th;
    private Socket sock;
    private DataOutputStream dos;
    private DataInputStream dis;
    private String name;
    
    public FenetreChatController(){
        try{
            sock = new Socket("127.0.0.1", 5007);
            dos = new DataOutputStream(sock.getOutputStream());
            dis = new DataInputStream(sock.getInputStream());
            
            th = new Thread(() -> {
                try {
                    while(true) {
                        String newMsg = dis.readUTF();

                        System.out.println("RE : " + newMsg);
                        
                        lvConversation.appendText(newMsg + "\n");
                    }
                } catch(IOException E) {
                    E.printStackTrace();
                }
            });
            th.start();
            
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    
    public void onEnvoyerMessage(){
        try{
            String msg = txtMessage.getText();
            dos.writeUTF(name + ": " + msg);
            //lvConversation.appendText(name + " : " + msg + "\n");
            txtMessage.setText("");
            txtMessage.requestFocus();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    
    public void quitConv(ActionEvent e){
        
        ((Node)e.getSource()).getScene().getWindow().hide();
    }
    
    public void onPressedEnter(KeyEvent e){
        if(e.getCode() == KeyCode.ENTER){
           onEnvoyerMessage();
        }
    }
   
    public void getUserProfil(Utilisateur us){
        try {
            name = us.getPseudo();
            dos.writeUTF(name);
            System.out.println("Pseudal : "+name);
        } catch (IOException ex) {
            ex.printStackTrace();    
        }
    } 
}
