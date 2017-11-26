/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modèle;

import javafx.collections.ObservableList;

/**
 *
 * @author lulauriche
 */
public class Conversation {
    private Utilisateur sender;
    private Utilisateur receiver;
    private ObservableList<Message> chat;

    public Conversation(Utilisateur sender, Utilisateur receiver, ObservableList<Message> chat) {
        this.sender = sender;
        this.receiver = receiver;
        this.chat = chat;
    }
    
    //<editor-fold desc="Getter/Setter" defaultstate="collapsed">
    public ObservableList<Message> getChat() {
        return chat;
    }

    public void setChat(ObservableList<Message> chat) {
        this.chat = chat;
    }

    public Utilisateur getSender() {
        return sender;
    }

    public void setSender(Utilisateur sender) {
        this.sender = sender;
    }

    public Utilisateur getReceiver() {
        return receiver;
    }

    public void setReceiver(Utilisateur receiver) {
        this.receiver = receiver;
    }
    //</editor-fold>
    
}
