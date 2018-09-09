/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager.Suppliers.Reports;

import Manager.Main.HomeController;
import database.DatabaseHandler;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author lolo
 */
public class Sppliers_ReportsController implements Initializable {

    HomeController x = new HomeController();
    
    @FXML
    private AnchorPane Suppliers_Reports;
    @FXML
    private Label S_name;
    @FXML
    private ComboBox<?> S_Cname;
    @FXML
    private Label S_Date1;
    @FXML
    private Label S_Date2;
    @FXML
    private HBox HBox;
    @FXML
    private DatePicker S_TData1;
    @FXML
    private DatePicker S_TDate2;

    /**
     * Initializes the controller class.
     */
    DatabaseHandler databaseHandler;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        databaseHandler=DatabaseHandler.getInstance();
    }    

    @FXML
    private void Suppliers_Returns(ActionEvent event) {
    }

    @FXML
    private void Suuplier_Financial(ActionEvent event) {
    }

    @FXML
    private void Suppliers_Invoices(ActionEvent event) {
    }
    
    
   
    
}
