/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modèle;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author lulauriche
 */
public class Message {
    private String idMessage;
    private Utilisateur auteur;
    private Utilisateur destinataire;
    private String contenu;
    private String date;

    public Message(String id, String contenu, String date,Utilisateur auteur,Utilisateur destinataire) {
        this.contenu = contenu;
        this.date = date;
        this.idMessage=id;
        this.auteur=auteur;
        this.destinataire=destinataire;
    }
    public Message(String id, String contenu, Utilisateur auteur,Utilisateur destinataire) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date=new Date();
        this.contenu = contenu;
        this.date = dateFormat.format(date);
        this.idMessage=id;
        this.auteur=auteur;
        this.destinataire=destinataire;
    }
    
    //<editor-fold desc="Getter/Setter" defaultstate="collapsed">
    
        public Utilisateur getAuteur() {
        return auteur;
    }

    public void setAuteur(Utilisateur auteur) {
        this.auteur = auteur;
    }

    public Utilisateur getDestinataire() {
        return destinataire;
    }

    public void setDestinataire(Utilisateur destinataire) {
        this.destinataire = destinataire;
    }
    public String getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(String idMessage) {
        this.idMessage = idMessage;
    }
    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    //</editor-fold>
    
}