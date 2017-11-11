/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testreseau;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class CloseSocket {

   public static void main(String[] args){
      Socket sock = null;
      try {
         //On se connecte à OpenClassrooms
         sock = new Socket("www.openclassrooms.com", 80);
         
         //...         
      } catch (UnknownHostException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
      finally{
         if(sock != null){
            try {
               sock.close();
            } catch (IOException e) {
               e.printStackTrace();
               sock = null;
            }
         }
      }
   }
}
