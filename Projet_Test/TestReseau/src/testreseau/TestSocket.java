/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testreseau;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestSocket {

   public static void main(String[] args) {
      try {
         Socket soc1 = new Socket(InetAddress.getByName("www.openclassrooms.com"), 80);
         Socket soc2 = new Socket("www.openclassrooms.com", 80);
         Socket soc3 = new Socket("toto", 80);
      } catch (UnknownHostException e) {
         e.printStackTrace();
      }catch (IOException e) {
         e.printStackTrace();
      }
   }
}
