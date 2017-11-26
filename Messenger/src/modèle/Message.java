/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modèle;

import java.util.Date;

/**
 *
 * @author lulauriche
 */
public class Message {
    private String contenu;
    private Date date;

    public Message(String contenu, Date date) {
        this.contenu = contenu;
        this.date = date;
    }
    
    //<editor-fold desc="Getter/Setter" defaultstate="collapsed">
    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    //</editor-fold>
    
}