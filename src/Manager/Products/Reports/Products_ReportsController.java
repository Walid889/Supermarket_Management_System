/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager.Products.Reports;

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
public class Products_ReportsController implements Initializable {
     HomeController x = new HomeController();
    @FXML
    private AnchorPane Product_Reports;
    @FXML
    private Label Products;

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
    private void Damadge_Reports(ActionEvent event) {
    }

    @FXML
    private void Inventory_Reports(ActionEvent event) {
    }

    @FXML
    private void Manager_Home(ActionEvent event) {
        x.loadwindow(Product_Reports, "/Manager/Main/Home.fxml");
    }

    @FXML
    private void Back(ActionEvent event) {
         x.loadwindow(Product_Reports, "/Manager/Reports/Reports.fxml");
    }
    
}
