/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import Classes.Alerts;
import database.DatabaseHandler;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author lolo
 */
public class LoginController implements Initializable {

    @FXML
    private AnchorPane login;
    @FXML
    private Label EnterCode;
    @FXML
    private Label Password;
    @FXML
    private TextField TEnterCode;
    @FXML
    private TextField TPassword;

    DatabaseHandler databaseHandler;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        databaseHandler = DatabaseHandler.getInstance();
        // TODO
    }    

    @FXML
    private void login(ActionEvent event) {
        //JOptionPane.showMessageDialog(null , "Login With Admin");
        //Alerts.ConfirmAlert("login with admin", "");    
    }
    
}
