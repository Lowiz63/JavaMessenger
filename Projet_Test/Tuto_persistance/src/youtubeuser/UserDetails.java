// This class acts as a model class,holding getters,setters and properties
package youtubeuser;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author admin
 */
public class UserDetails {

    private final StringProperty nom;
    private final StringProperty prenom;
    private final StringProperty pseudo;
    private final StringProperty mdp;
    private final StringProperty adresse;
    private final StringProperty tel;

    //Default constructor
    public UserDetails(String nom, String prenom, String pseudo, String mdp, String adresse, String tel) {
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
        this.pseudo = new SimpleStringProperty(pseudo);
        this.mdp = new SimpleStringProperty(mdp);
        this.adresse = new SimpleStringProperty(adresse);
        this.tel = new SimpleStringProperty(tel);
    }

    //Getters
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
    
}
