/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employees.recall;


import com.jfoenix.controls.JFXRadioButton;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;

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

import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

import javafx.scene.control.ToggleGroup;

import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author NOUR
 */
public class RecallController implements Initializable {
    EmployeesController x = new EmployeesController();
    @FXML
    private AnchorPane loadPane;
    @FXML
    private Label date;
    @FXML

    private JFXRadioButton client_select;
    @FXML
    private TableColumn<?, ?> t_code;
    @FXML
    private TableColumn<?, ?> t_product;
    @FXML
    private TableColumn<?, ?> t_price;
    @FXML
    private TableColumn<?, ?> t_qty;
    @FXML
    private TableColumn<?, ?> t_recall;
    @FXML
    private TextField quantity;
    @FXML
    private JFXRadioButton company_select;

    private JFXTextField R_SearchField;
    @FXML
    private JFXButton R_SearchButton;
    @FXML
    private JFXRadioButton R_FCustomer;
    @FXML
    private ToggleGroup RecallFrom;
    @FXML
    private Label productBarcode;
    @FXML
    private Label productName;
    @FXML
    private Label productPrice;
    @FXML
    private JFXRadioButton R_ToCampany;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @FXML
    private void loadMainOfRecall(ActionEvent event) {
    //loadWindow ("/employees/main/employees.fxml");
        x.loadwindow(loadPane, "/employees/main/employees.fxml");
    }

    @FXML
    private void AddRecall(ActionEvent event) {
    }
    
    
}
