/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager.Employee.Reports;

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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    
}
