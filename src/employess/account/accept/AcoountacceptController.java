/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employess.account.accept;

import com.jfoenix.controls.JFXButton;
import employees.main.EmployeesController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
    private JFXButton accountaccept;
    @FXML
    private JFXButton personalexpenses;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loadAccountAccept(ActionEvent event) {
        //loadWindow("/employees/account/accept/attendence/attendence.fxml");
        x.loadwindow(loadPane,"/employees/account/accept/attendence/attendence.fxml");
    }

    @FXML
    private void loadPersonalExpenses(ActionEvent event) {
        //loadWindow("/employees/personalexpenses/personalexpenses.fxml");
        x.loadwindow(loadPane,"/employees/personalexpenses/personalexpenses.fxml");
    }

    @FXML
    private void loadBack(ActionEvent event) {
        //loadWindow("/employees/account/account.fxml");
        x.loadwindow(loadPane,"/employees/account/account.fxml");
    }
    
   /* void loadWindow(String loc)
    {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource(loc));
            loadPane.getChildren().setAll(pane);
           
        } catch (IOException ex) {
            Logger.getLogger(EmployeesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/

}
