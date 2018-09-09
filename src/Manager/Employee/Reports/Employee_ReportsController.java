/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager.Employee.Reports;

import Manager.Main.HomeController;
import database.DatabaseHandler;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;


/**
 * FXML Controller class
 *
 * @author lolo
 */
public class Employee_ReportsController implements Initializable {
  
    HomeController x = new HomeController();
    
    @FXML
    private AnchorPane E_Reports;
    @FXML
    private ComboBox<?> E_combo_name;
    @FXML
    private Label E_lable_name;
    @FXML
    private Label E_label_date1;
    @FXML
    private Label E_label_date2;
    @FXML
    private DatePicker E_field_date1;
    @FXML
    private DatePicker E_field_date2;

    /**
     * Initializes the controller class.
     */
    DatabaseHandler databaseHandler;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       databaseHandler = DatabaseHandler.getInstance();
    }    

    @FXML
    private void Salary_Report(ActionEvent event) {
    }

    @FXML
    private void Purchases_Report(ActionEvent event) {
    }

    @FXML
    private void Attendance_Report(ActionEvent event) {
    }

    @FXML
    private void Manager_Home(ActionEvent event) {
        x.loadwindow(E_Reports, "/Manager/Main/Home.fxml");
    }
    
}
