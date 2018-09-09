/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employess.account.accept;

import employees.main.EmployeesController;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author NOUR
 */
public class AcoountacceptController implements Initializable {
    EmployeesController x = new EmployeesController();

    @FXML
    private AnchorPane loadPane;
    @FXML
    private JFXButton personalexpenses;
    @FXML
    private JFXButton accountacceptbutton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loadAccountAccept(ActionEvent event) {
        x.loadwindow(loadPane,"/employees/account/accept/attendence/attendence.fxml");
    }

    @FXML
    private void loadPersonalExpenses(ActionEvent event) {
        x.loadwindow(loadPane,"/employees/personalexpenses/personalexpenses.fxml");
    }

    @FXML
    private void loadBack(ActionEvent event) {
        x.loadwindow(loadPane,"/employees/account/account.fxml");
    }
    
}
