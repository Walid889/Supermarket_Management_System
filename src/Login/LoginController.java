/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import Classes.Alerts;

import Classes.Login;
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
import org.apache.commons.codec.digest.DigestUtils;


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
    Login preference;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //databaseHandler = DatabaseHandler.getInstance();
        //preference = Login.getPreferences();
        // TODO
    }    

    @FXML
    private void login(ActionEvent event) {

        Login a = new Login();
 
            a.setcode(TEnterCode.getText());
            a.setPassword(TPassword.getText());
          
 
            if(a.getcode().equals("admin") && a.getPassword().equals("admin")){
                JOptionPane.showMessageDialog(null, "Login with Admin");
                
                }
 
            else{
                JOptionPane.showMessageDialog(null, "Failed Login");
                
                }

        //JOptionPane.showMessageDialog(null , "Login With Admin");
        //Alerts.ConfirmAlert("login with admin", "");    

    }
    
}
