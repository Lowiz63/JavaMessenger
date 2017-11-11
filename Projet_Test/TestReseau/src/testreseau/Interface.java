/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testreseau;

import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class Interface {

   public static void main(String[] args) {
      
      try {         
         //Nous spécifions que la réponse devra se faire par ce chemin
         InetAddress lo = InetAddress.getByName("192.168.2.30");
         
         //Le fait de mettre 0 dans le numéro de port de réponse
         //informe que n'importe quel numéro est accepté
         Socket soc = new Socket("www.openclassrooms.com", 80, lo, 0);         
      }catch (UnknownHostException e) {
         e.printStackTrace();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
