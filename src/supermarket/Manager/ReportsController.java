/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket.Manager;

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
        x.loadwindow("/supermarket/Manager/Products_Reports.fxml", "products_Reports");
    }

    @FXML
    private void loadFinancial_Reports(ActionEvent event) {
        x.loadwindow("/supermarket/Manager/Financial_Reports.fxml", "Financail_Reports");
    }

    @FXML
    private void loadEmployee_Report(ActionEvent event) {
        x.loadwindow("/supermarket/Manager/Employee_Reports.fxml", "Employee_Reports");
    }

    @FXML
    private void loadSuppliers_Report(ActionEvent event) {
        x.loadwindow("/supermarket/Manager/Sppliers_Reports.fxml", "Suppliers_Reports");
    }
}
