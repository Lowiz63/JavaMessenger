/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testsqlite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author thyzavard
 */
public class InscriptionModel {
    Connection connection;
    
    public InscriptionModel(){
        connection = SqliteConnection.Connector();
        if(connection == null){
            System.out.println("Connection not successful");
            System.exit(1);
        }
    }
    
    public boolean isDbConnected(){
        try{
            return !connection.isClosed();
        } catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
    public void insert(String user, String mdp) throws SQLException{
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String query = "insert into User values(?, ?)";
        try{
           preparedStatement = connection.prepareStatement(query);
           preparedStatement.setString(1, user);
           preparedStatement.setString(2, mdp);
           resultSet = preparedStatement.executeQuery();
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            preparedStatement.close();
            resultSet.close();
        }
    }
}





//Connection connection;
//    
//    public LoginModel(){
//        connection = SqliteConnection.Connector();
//        if(connection == null){
//            System.out.println("Connection not successful");
//            System.exit(1);
//        }
//    }
//    
//    public boolean isDbConnected(){
//        try{
//            return !connection.isClosed();
//        } catch(SQLException e){
//            e.printStackTrace();
//            return false;
//        }
//    }
//    
//    public boolean isLogin(String user, String mdp) throws SQLException {
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//        String query = "select * from User where pseudo = ? and mdp = ?";
//        try{
//           preparedStatement = connection.prepareStatement(query);
//           preparedStatement.setString(1, user);
//           preparedStatement.setString(2, mdp);
//           
//           resultSet = preparedStatement.executeQuery();
//           if(resultSet.next()){
//               return true;
//           } else {
//               return false;
//           }
//        }catch(Exception e){
//            e.printStackTrace();
//            return false;
//        } finally {
//            preparedStatement.close();
//            resultSet.close();
//        }
//    }
//}
