/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modèle;

/**
 *
 * @author lulauriche
 */
public enum Etat {
    LIGNE,
    OCCUPE,
    HORS_LIGNE;
  public static Etat toEtat(String txt){
        if (txt.equals(LIGNE)){
        return LIGNE;
        }
        if (txt.equals(OCCUPE)){
        return OCCUPE;
        }
        if (txt.equals(HORS_LIGNE)){
        return HORS_LIGNE;
        }
        return null;
    }

}
