/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employees.buying;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import employees.main.EmployeesController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author NOUR
 */
public class BuyingController implements Initializable {
    @FXML
    private JFXButton save;
    @FXML
    private JFXButton delete;
    @FXML
    private JFXButton loadMain;
    @FXML
    private Label date;
    @FXML
    private JFXButton search;
    @FXML
    private TextField billNumber;
    @FXML
    private Label productName;
    @FXML
    private Label productVolume;
    @FXML
    private Label productPrise;
    @FXML
    private TextField Quntity;
    @FXML
    private TextField tatalPrice;
    @FXML
    private TextField paid;
    @FXML
    private TextField rest;
    @FXML
    private JFXComboBox<?> quntityComboBox;
    @FXML
    private AnchorPane loadPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loadMainOfBuying(ActionEvent event) {
        loadWindow ("/employees/main/employees.fxml");
    }
    
    
    void loadWindow(String loc)
    {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource(loc));
            loadPane.getChildren().setAll(pane);
           
        } catch (IOException ex) {
            Logger.getLogger(EmployeesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
