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
public class Manager_EmployeeController implements Initializable {
     HomeController x = new HomeController();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     
    }    

    @FXML
    private void Employee_Reports(ActionEvent event) {
        x.loadwindow("/supermarket/Manager/Employee_Reports.fxml", "Employee_Reports");
    }

    @FXML
    private void Manager_Home(ActionEvent event) {
        x.loadwindow("/supermarket/Manager/Home.fxml", "Home");
    }
       
}
