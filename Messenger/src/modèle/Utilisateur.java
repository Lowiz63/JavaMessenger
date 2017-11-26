/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modèle;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.ObservableList;

/**
 *
 * @author lulauriche
 */
public class Utilisateur implements Observable{
    private ObservableList<Utilisateur> listContact;
    private String nom;
    private String prenom;
    private String adresse;
    private String login;
    private String mdp;
    private Estat statut;
    private boolean connect=false;

    public Utilisateur (String nom, String prenom, String adresse,String login, String mdp){
        this.setAdresse(adresse);
        this.setLogin(login);
        this.setMdp(mdp);
        this.setNom(nom);
        this.setPrenom(prenom);        
    }
    
    //<editor-fold desc="Getter/Setter" defaultstate="collapsed">
    public ObservableList<Utilisateur> getListContact() {
        return listContact;
    }

    public void setListContact(ObservableList<Utilisateur> listContact) {
        this.listContact = listContact;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Estat getStatut() {
        return statut;
    }

    public void setStatut() {
        if(isConnect()){
            this.statut=Estat.LIGNE;
        }
        else {
            this.statut=Estat.HORS_LIGNE;
        }        
    }

    public boolean isConnect() {
        return connect;
    }

    public void setConnect(boolean connect) {
        this.connect = connect;
    }
    //</editor-fold>
    
    
    // Methode abstraite d'observable
    @Override
    public void addListener(InvalidationListener listener) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeListener(InvalidationListener listener) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
    
}
