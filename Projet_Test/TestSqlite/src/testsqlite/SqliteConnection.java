/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testsqlite;

import java.sql.*;

/**
 *
 * @author thyzavard
 */
public class SqliteConnection {
    
    public static Connection Connector(){
        try{
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:User.sqlite");
            return conn;
        } catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
 
}
