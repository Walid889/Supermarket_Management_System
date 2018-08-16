/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager.Reports;

import Manager.Main.HomeController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author lolo
 */
public class ReportsController implements Initializable {

       HomeController x = new HomeController();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     @FXML
    private void loadproducts_Report(ActionEvent event) {
        x.loadwindow("/Manager/Products/Reports/Products_Reports.fxml", "Products_Reports");
    }

    @FXML
    private void loadFinancial_Reports(ActionEvent event) {
        x.loadwindow("/Manager/Financial/Reports/Financial_Reports.fxml", "Financail_Reports");
    }

    @FXML
    private void loadEmployee_Report(ActionEvent event) {
        x.loadwindow("/Manager/Employee/Reports/Employee_Reports.fxml", "Employee_Reports");
    }

    @FXML
    private void loadSuppliers_Report(ActionEvent event) {
        x.loadwindow("/Manager/Suppliers/Reports/Sppliers_Reports.fxml", "Suppliers_Reports");
    }
}
