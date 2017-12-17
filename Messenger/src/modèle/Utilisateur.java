/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modèle;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import static modèle.Etat.toEtat;

/**
 *
 * @author lulauriche
 */
public  class Utilisateur{
    private ObservableList<Utilisateur> listContact;

    private Etat statut;
    
    private final StringProperty nom;
    private final StringProperty prenom;
    private final StringProperty pseudo;
    private final StringProperty mdp;
    private final StringProperty adresse;
    private final StringProperty tel;
    private final IntegerProperty port;

    public Utilisateur (String nom, String prenom, String pseudo,String mdp, String adresse,String tel, String statut, int port){
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
        this.pseudo = new SimpleStringProperty(pseudo);
        this.mdp = new SimpleStringProperty(mdp);
        this.adresse = new SimpleStringProperty(adresse);
        this.tel = new SimpleStringProperty(tel);
        this.port = new SimpleIntegerProperty(port);
        this.statut=toEtat(statut);
    }
    
    public Utilisateur (String nom, String prenom, String pseudo,String mdp, String adresse,String tel, int port){
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
        this.pseudo = new SimpleStringProperty(pseudo);
        this.mdp = new SimpleStringProperty(mdp);
        this.adresse = new SimpleStringProperty(adresse);
        this.tel = new SimpleStringProperty(tel);
        this.port = new SimpleIntegerProperty(port);
        this.statut=toEtat("HORS_LIGNE");
    }
    
    //<editor-fold desc="Getter/Setter" defaultstate="collapsed">
    public ObservableList<Utilisateur> getListContact() {
        return listContact;
    }

    public void setListContact(ObservableList<Utilisateur> listContact) {
        this.listContact = listContact;
    }

    public String getNom() {
        return nom.get();
    }

    public String getPrenom() {
        return prenom.get();
    }

    public String getPseudo() {
        return pseudo.get();
    }
    
    public String getMdp() {
        return mdp.get();
    }
    
    public String getAdresse() {
        return adresse.get();
    }
    
    public String getTel() {
        return tel.get();
    }
    
    public int getPort(){
        return port.get();
    }

    //Setters
    public void setNom(String value) {
        nom.set(value);
    }

    public void setPrenom(String value) {
        prenom.set(value);
    }

    public void setPseudo(String value) {
        pseudo.set(value);
    }
    
    public void setMdp(String value) {
        mdp.set(value);
    }
    
    public void setAdresse(String value) {
        adresse.set(value);
    }
    
    public void setTel(String value) {
        tel.set(value);
    }

    public void setPort(int value){
        port.set(value);
    }
    
    //Property values
    public StringProperty nomProperty() {
        return nom;
    }

    public StringProperty pseudoProperty() {
        return pseudo;
    }

    public StringProperty prenomProperty() {
        return prenom;
    }

    public StringProperty mdpProperty() {
        return mdp;
    }

    public StringProperty adresseProperty() {
        return adresse;
    }

    public StringProperty telProperty() {
        return tel;
    }

    public IntegerProperty portProperty(){
        return port;
    }
    
    public Etat getStatut() {
        return statut;
    }

    public void setStatut(String actuel) {
        this.statut=Etat.toEtat(actuel);
    }
    //</editor-fold>

    @Override
   public String toString(){
       return "Nom: "+this.getNom()+" Prénom: "+this.getPrenom();
   }
   public void addUserToContact(Utilisateur contact){
       listContact.add(contact);       
   }
    
}
