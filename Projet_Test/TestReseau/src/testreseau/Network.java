/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testreseau;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class Network {

   public static void main(String[] args) {
      try {
         Enumeration<NetworkInterface> list = NetworkInterface.getNetworkInterfaces();
         
         while(list.hasMoreElements()){
            
            NetworkInterface ni = list.nextElement();
            Enumeration<InetAddress> listAddress = ni.getInetAddresses();
            
            while(listAddress.hasMoreElements()){
               InetAddress address = listAddress.nextElement();
               showInformations(address);
            }
            
         }
      } catch (SocketException e) {
         e.printStackTrace();
      }
   }
   
   public static void showInformations(InetAddress address){
      System.out.println("-----------------------------------------------");
      System.out.println("Nom  : " + address.getHostName());
      System.out.println("Adresse : " + address.getHostAddress());
      System.out.println("Nom canonique : " + address.getCanonicalHostName());
   }
}