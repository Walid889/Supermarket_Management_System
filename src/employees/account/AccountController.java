/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employees.account;

import Classes.Alerts;
import Classes.Employee;
import database.DataHelper;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author NOUR
 */
public class AccountController implements Initializable {
    EmployeesController x = new EmployeesController();
    @FXML
    private AnchorPane loadPane;
    @FXML
    private TextField code_employee;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loadMainOfAccount(ActionEvent event) {
        //loadWindow("/employees/main/employees.fxml");
        x.loadwindow(loadPane,"/employees/main/employees.fxml");
    }

    private void loadAccount(ActionEvent event) {
       // loadWindow("/employees/account/accepted/accountaccept.fxml");
        x.loadwindow(loadPane,"/employees/account/accepted/accountaccept.fxml");
    }
    
    /*void loadWindow(String loc)
    {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource(loc));
            loadPane.getChildren().setAll(pane);
           
        } catch (IOException ex) {
            Logger.getLogger(EmployeesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/

    private void login_employee()
    {
        Employee e = new Employee();
        try{
        e.setEmployeeId(code_employee.getText());
        boolean result = DataHelper.isEmployeeRegistered(e.getEmployeeId());
        if(result){
           Alerts.showInfoAlert("كود صحيح");
        }
        }catch(Exception a)
        {
            Alerts.showErrorAlert("كود موظف خطأ");

        }
    }
    @FXML
    private void confirm(ActionEvent event) {
    this.login_employee();
    }
}
