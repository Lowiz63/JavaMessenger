/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youtubeuser;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author admin
 */
public class FXMLUserController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private TableView<UserDetails> tableUser;
    @FXML
    private TableColumn<UserDetails, String> columnNom;
    @FXML
    private TableColumn<UserDetails, String> columnPrenom;
    @FXML
    private TableColumn<UserDetails, String> columnPseudo;
    @FXML
    private Button btnLoad;
    //Initialize observable list to hold out database data
    private ObservableList<UserDetails> data;
    private DbConnection dc;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        dc = new DbConnection();
    }

    @FXML
    private void loadDataFromDatabase(ActionEvent event) {
        try {
            Connection conn = dc.Connect();
            data = FXCollections.observableArrayList();
            // Execute query and store result in a resultset
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM User");
            while (rs.next()) {
                //get string from db,whichever way 
                data.add(new UserDetails(rs.getString(1),rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5),rs.getInt(6)));
                
            }

        } catch (SQLException ex) {
            System.err.println("Error"+ex);
        }
        
        //Set cell value factory to tableview.
        //NB.PropertyValue Factory must be the same with the one set in model class.
        columnNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        columnPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        columnPseudo.setCellValueFactory(new PropertyValueFactory<>("pseudo"));
        
        tableUser.setItems(null);
        tableUser.setItems(data);

    }

}
