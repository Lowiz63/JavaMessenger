/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import static DAL.UserGateway.findUserByPseudo;
import static DAL.UserGateway.initializeUsers;
import static java.lang.System.exit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import javafx.collections.ObservableList;
import modèle.DbConnection;
import modèle.Utilisateur;

/**
 *
 * @author blood
 */
public class ContactGateway {
    private static Connection co=DbConnection.Connect();
    private static PreparedStatement pst =null;
    private static ResultSet rs;
    private static ObservableList<Utilisateur> users=initializeUsers();
    
    public static void initializeContacts(Utilisateur user){
        if(co==null){
            System.out.println("Connexion Null");
            exit(1);
        }
        try{
            pst=co.prepareStatement("SELECT * FROM contact WHERE userOne=? OR userTwo=?");
            pst.setString(1, user.getPseudo());
            pst.setString(2, user.getPseudo());
            rs=pst.executeQuery();
            while(rs.next()){
                if(rs.getString("userOne").equals(user.getPseudo())){
                    System.out.println("1");
                    user.addUserToContact(findUserByPseudo(rs.getString("userTwo")));
                }
                if(rs.getString("userTwo").equals(user.getPseudo())){
                    System.out.println("2");
                    user.addUserToContact(findUserByPseudo(rs.getString("userOne")));
                }
            }
            rs.close();
            pst.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static boolean insertContact(Utilisateur user, String pseudo)throws Exception{
        if(co==null){
            System.out.println("Connexion Null");
            exit(1);
        }
        pst=co.prepareStatement("INSERT INTO contact VALUES(?,?)");
        pst.setString(1, user.getPseudo());
        pst.setString(2, pseudo);         
        Iterator it=users.iterator();
        int i=0;
        while(it.hasNext()){
            if(users.get(i).getPseudo().equals(pseudo)){
               if(user.getListContact()!=null && user.getListContact().contains(users.get(i))){
                    return false;
                }
                pst.executeUpdate();
                pst.close();
                //user.addUserToContact(users.get(i));
                return true;
            }
            i++;
            it.next();
        }
        pst.close();
        return false;
        
    }
}
