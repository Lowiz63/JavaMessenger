/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import java.util.Iterator;
import javafx.collections.ObservableList;
import modèle.Utilisateur;

/**
 *
 * @author ludo
 */
public class Validation {
    public static Utilisateur validationUser(String username, String mdp, ObservableList<Utilisateur> users){
        Iterator it=users.iterator();
        int i=0;
        while(it.hasNext()){
            if(users.get(i).getPseudo().equals(username)&&users.get(i).getMdp().equals(mdp)){
                return users.get(i);
            }
            i++;
            it.next();
        }
        return null;
    }
}
