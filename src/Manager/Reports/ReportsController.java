/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager.Reports;

import Manager.Main.HomeController;
import database.DatabaseHandler;
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
public class ReportsController implements Initializable {

    HomeController x = new HomeController();
    
    DatabaseHandler databaseHandler;
    @FXML
    private AnchorPane Reports;
    @FXML
    private Label LReports;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        databaseHandler=DatabaseHandler.getInstance();
    }    
     @FXML
    private void loadproducts_Report(ActionEvent event) {
        x.loadwindow(Reports,"/Manager/Products/Reports/Products_Reports.fxml");
    }

    @FXML
    private void loadFinancial_Reports(ActionEvent event) {
        x.loadwindow(Reports,"/Manager/Financial/Reports/Financial_Reports.fxml");
    }

    @FXML
    private void loadEmployee_Report(ActionEvent event) {
        x.loadwindow(Reports,"/Manager/Employee/Reports/Employee_Reports.fxml");
    }

    @FXML
    private void loadSuppliers_Report(ActionEvent event) {
        x.loadwindow(Reports,"/Manager/Suppliers/Reports/Sppliers_Reports.fxml");
    }

    @FXML
    private void Back(ActionEvent event) {
        x.loadwindow(Reports,"/Manager/Main/Home.fxml");
    }
}
