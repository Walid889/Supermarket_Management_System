/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager.Financial.Reports;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author lolo
 */
public class Financial_ReportsController implements Initializable {

    @FXML
    private AnchorPane Financial_Reports;
    @FXML
    private Label financial;
    @FXML
    private Label F_date1;
    @FXML
    private Label F_date2;
    @FXML
    private DatePicker F_Tdate1;
    @FXML
    private DatePicker F_Tdate2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Expenses_Reports(ActionEvent event) {
    }

    @FXML
    private void invoices_Reports(ActionEvent event) {
    }

    @FXML
    private void Daily_Report(ActionEvent event) {
    }
    
}
