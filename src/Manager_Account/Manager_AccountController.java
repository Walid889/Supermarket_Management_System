/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager_Account;

import Manager.Main.HomeController;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author lolo
 */
public class Manager_AccountController implements Initializable {
    HomeController x = new HomeController();
    @FXML
    private AnchorPane Account;
    @FXML
    private Label Code;
    @FXML
    private Label RPassword;
    @FXML
    private Label Password;
    @FXML
    private JFXTextField T_Code;
    @FXML
    private JFXPasswordField T_Password;
    @FXML
    private JFXPasswordField T_RPassword;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Edit_Account(ActionEvent event) {
    }

    @FXML
    private void Back(ActionEvent event) {
        x.loadwindow(Account,"/Manager/Main/Home.fxml");
    }
    
}
